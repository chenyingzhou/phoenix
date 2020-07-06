package com.phoenix.message.controller;

import com.phoenix.message.model.dto.BaseResponse;
import com.phoenix.message.model.dto.request.AuthLoginReq;
import com.phoenix.message.model.dto.response.auth.LoginResp;
import com.phoenix.message.model.dto.response.auth.MenuResp;
import com.phoenix.message.model.dto.response.auth.ResourceResp;
import com.phoenix.message.model.po.entity.AdminUser;
import com.phoenix.message.model.po.entity.AdminUserNode;
import com.phoenix.message.model.vo.AuthMenu;
import com.phoenix.message.util.JacksonUtil;
import com.phoenix.message.constant.SessionConstant;
import com.phoenix.message.controller.handler.exception.BizException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController
public class AuthController extends BaseController {
    @PostMapping("/auth/login")
    public BaseResponse<LoginResp> login(@RequestBody AuthLoginReq authLoginReq, HttpSession session) {
        var username = authLoginReq.getUsername();
        var password = authLoginReq.getPassword();
        var resp = new LoginResp();
        var adminUser = authService.findAdminUserByUsername(username);
        var success = null != adminUser && authService.login(adminUser, password);
        if (success) {
            session.setAttribute(SessionConstant.ADMIN_USER, adminUser);
            resp.setToken(session.getId());
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
    public BaseResponse<MenuResp> menu(HttpSession session) {
        var adminUser = (AdminUser)session.getAttribute(SessionConstant.ADMIN_USER);
        var adminUserNode = authService.findAdminUserNodeByUserId(adminUser.getId());
        if (null == adminUserNode) {
            adminUserNode = new AdminUserNode();
            adminUserNode.setNodeIdList(new ArrayList<>());
        }
        var adminNodeIdList = adminUserNode.getNodeIdList();
        var adminNodeList = authService.findAdminNodeList(adminNodeIdList);
        var authMenuRoot = authService.adminNodeList2AuthMenuTree(adminNodeList, new AuthMenu());
        var authMenuResp = JacksonUtil.transObject(authMenuRoot, MenuResp.class);
        return sendData(authMenuResp);
    }

    @GetMapping("/auth/resource")
    public BaseResponse<ResourceResp> resource(HttpSession session) {
        var adminUser = (AdminUser)session.getAttribute(SessionConstant.ADMIN_USER);
        var resp = new ResourceResp();
        resp.setAppPlatformList(adminUser.getAppPlatformList());
        resp.setMessageTypeList(adminUser.getMessageTypeList());
        return sendData(resp);
    }

}
