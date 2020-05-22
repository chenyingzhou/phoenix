package com.vova.phoenix.controller;

import com.vova.phoenix.constant.SessionConstant;
import com.vova.phoenix.controller.handler.exception.BizException;
import com.vova.phoenix.model.converter.P2V;
import com.vova.phoenix.model.converter.beancopy.CachedBeanCopier;
import com.vova.phoenix.model.dto.BaseListResponse;
import com.vova.phoenix.model.dto.BaseResponse;
import com.vova.phoenix.model.dto.request.AuthLoginReq;
import com.vova.phoenix.model.dto.response.AuthLoginResp;
import com.vova.phoenix.model.dto.response.AuthMenuResp;
import com.vova.phoenix.model.dto.response.AuthResourceResp;
import com.vova.phoenix.model.po.entity.AdminUser;
import com.vova.phoenix.model.po.entity.AdminUserNode;
import com.vova.phoenix.model.vo.AuthMenu;
import com.vova.phoenix.model.vo.Operator;
import com.vova.phoenix.util.JacksonUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController
public class AuthController extends BaseController {
    @PostMapping("/auth/login")
    public BaseResponse<AuthLoginResp> login(@RequestBody AuthLoginReq authLoginReq, HttpSession session) {
        var username = authLoginReq.getUsername();
        var password = authLoginReq.getPassword();
        var resp = new AuthLoginResp();
        var adminUser = authService.findAdminUserByUsername(username);
        var success = null != adminUser && authService.login(adminUser, password);
        if (success) {
            session.setAttribute(SessionConstant.ADMIN_USER, adminUser);
            session.setAttribute(SessionConstant.OPERATOR, P2V.ADMIN_USER_2_OPERATOR.convert(adminUser));
            resp.setCertificate(session.getId());
            return sendData(resp);
        } else {
            session.setAttribute(SessionConstant.ADMIN_USER, null);
            throw new BizException("账号或密码错误");
        }
    }

    @PostMapping("/auth/logout")
    public BaseResponse<Object> logout(HttpSession session) {
        session.removeAttribute(SessionConstant.ADMIN_USER);
        session.removeAttribute(SessionConstant.OPERATOR);
        return sendOk("退出成功");
    }

    @GetMapping("/auth/menu")
    public BaseListResponse<AuthMenuResp> menu(HttpSession session) {
        var adminUser = (AdminUser)session.getAttribute(SessionConstant.ADMIN_USER);
        var adminUserNode = authService.findAdminUserNodeByUserId(adminUser.getId());
        if (null == adminUserNode) {
            adminUserNode = new AdminUserNode();
            adminUserNode.setNodeIds(JacksonUtil.toJSon(new ArrayList<>()));
        }
        var adminNodeIdList = JacksonUtil.toList(adminUserNode.getNodeIds(), Integer.class);
        var adminNodeList = authService.findAdminNodeByIdList(adminNodeIdList);
        var authMenuRoot = authService.adminNodeList2AuthMenuTree(adminNodeList, new AuthMenu());
        var authMenuRespRoot = new AuthMenuResp();
        CachedBeanCopier.copy(authMenuRoot, authMenuRespRoot);
        return sendList(authMenuRespRoot.getChildren());
    }

    @GetMapping("/auth/resource")
    public BaseResponse<AuthResourceResp> resource(HttpSession session) {
        var operator = (Operator)session.getAttribute(SessionConstant.OPERATOR);
        var resp = new AuthResourceResp();
        resp.setAppPlatformList(operator.getAppPlatformList());
        resp.setMessageTypeList(operator.getMessageTypeList());
        return sendData(resp);
    }

}
