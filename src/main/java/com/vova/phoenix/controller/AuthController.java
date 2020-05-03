package com.vova.phoenix.controller;

import com.vova.phoenix.constant.SessionConstant;
import com.vova.phoenix.model.dto.BaseResponse;
import com.vova.phoenix.model.dto.request.AuthLoginReq;
import com.vova.phoenix.model.dto.response.AuthLoginResp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AuthController extends BaseController {
    @PostMapping("/auth/login")
    public BaseResponse<Object> login(@RequestBody AuthLoginReq authLoginReq, HttpSession session) {
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
            return sendFail("账号或密码错误");
        }
    }

}
