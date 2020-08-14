package com.phoenix.message.web.controller;

import com.phoenix.message.common.constant.SessionConstant;
import com.phoenix.message.common.dto.auth.AuthRoleTree;
import com.phoenix.message.common.entity.AuthRole;
import com.phoenix.message.common.entity.AuthUser;
import com.phoenix.message.common.util.JacksonUtil;
import com.phoenix.message.web.model.BaseListResponse;
import com.phoenix.message.web.model.response.AuthRoleTreeRsp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class AuthController extends BaseController {
    @GetMapping("/auth/role-tree")
    public BaseListResponse<AuthRoleTreeRsp> roleTree(HttpSession session) {
        AuthUser authUser = (AuthUser) session.getAttribute(SessionConstant.USER);
        List<AuthRole> authRoleList = authService.findRoleListByUserId(authUser.getId());
        AuthRoleTree authRoleTree = authService.authRoleListToTree(authRoleList, new AuthRoleTree());

        AuthRoleTreeRsp authRoleTreeRsp = JacksonUtil.transObject(authRoleTree, AuthRoleTreeRsp.class);
        return sendList(authRoleTreeRsp.getChildren());
    }
}
