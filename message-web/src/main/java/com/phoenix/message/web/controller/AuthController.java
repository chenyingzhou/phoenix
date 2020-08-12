package com.phoenix.message.web.controller;

import com.phoenix.message.common.model.dto.BaseResponse;
import com.phoenix.message.common.model.dto.request.AuthLoginReq;
import com.phoenix.message.common.model.dto.response.auth.LoginResp;
import com.phoenix.message.common.model.dto.response.auth.MenuResp;
import com.phoenix.message.common.model.dto.response.auth.ResourceResp;
import com.phoenix.message.common.model.po.entity.AdminUser;
import com.phoenix.message.common.model.po.entity.AdminUserNode;
import com.phoenix.message.common.model.vo.AuthMenu;
import com.phoenix.message.common.service.AuthService;
import com.phoenix.message.common.util.JacksonUtil;
import com.phoenix.message.common.constant.SessionConstant;
import com.phoenix.message.web.controller.handler.exception.BizException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController
public class AuthController extends BaseController {

    @GetMapping("/auth/menu")
    public BaseResponse<MenuResp> menu(HttpSession session) {
        var adminUser = (AdminUser)session.getAttribute(SessionConstant.USER);
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
        var adminUser = (AdminUser)session.getAttribute(SessionConstant.USER);
        var resp = new ResourceResp();
        resp.setAppPlatformList(adminUser.getAppPlatformList());
        resp.setMessageTypeList(adminUser.getMessageTypeList());
        return sendData(resp);
    }

}
