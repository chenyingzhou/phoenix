package com.vova.phoenix.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.vova.phoenix.constant.SessionConstant;
import com.vova.phoenix.controller.handler.exception.BizException;
import com.vova.phoenix.model.converter.beancopy.CachedBeanCopier;
import com.vova.phoenix.model.dto.BaseListResponse;
import com.vova.phoenix.model.dto.BaseResponse;
import com.vova.phoenix.model.dto.request.AuthLoginReq;
import com.vova.phoenix.model.dto.response.AuthLoginResp;
import com.vova.phoenix.model.dto.response.AuthMenuResp;
import com.vova.phoenix.model.dto.response.AuthResourceResp;
import com.vova.phoenix.model.repository.AdminUser;
import com.vova.phoenix.model.repository.AdminUserNode;
import com.vova.phoenix.model.vo.AuthMenu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
        return sendOk("退出成功");
    }

    @GetMapping("/auth/menu")
    public BaseListResponse<AuthMenuResp> menu(HttpSession session) {
        var adminUser = (AdminUser)session.getAttribute(SessionConstant.ADMIN_USER);
        var adminUserNode = authService.findAdminUserNodeByUserId(adminUser.getId());
        if (null == adminUserNode) {
            adminUserNode = new AdminUserNode();
            adminUserNode.setNodeIds(JSON.toJSONString(new ArrayList<>()));
        }
        var adminNodeIdList = JSON.parseObject(adminUserNode.getNodeIds(), new TypeReference<List<Integer>>(){});
        var adminNodeList = authService.findAdminNodeByIdList(adminNodeIdList);
        var authMenuRoot = authService.adminNodeList2AuthMenuTree(adminNodeList, new AuthMenu());
        var authMenuRespRoot = new AuthMenuResp();
        CachedBeanCopier.copy(authMenuRoot, authMenuRespRoot);
        return sendList(authMenuRespRoot.getChildren());
    }

    @GetMapping("/auth/resource")
    public BaseResponse<AuthResourceResp> resource(HttpSession session) {
        var adminUser = (AdminUser)session.getAttribute(SessionConstant.ADMIN_USER);
        var appPlatformList = JSON.parseObject(adminUser.getAppPlatformList(), new TypeReference<List<String>>(){});
        var messageTypeList = JSON.parseObject(adminUser.getMessageTypeList(), new TypeReference<List<String>>(){});
        var resp = new AuthResourceResp();
        resp.setAppPlatformList(appPlatformList);
        resp.setMessageTypeList(messageTypeList);
        return sendData(resp);
    }

}
