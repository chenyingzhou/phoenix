package com.vova.phoenix.controller;

import com.vova.phoenix.constant.SessionConstant;
import com.vova.phoenix.model.dto.request.AuthLoginReq;
import com.vova.phoenix.model.dto.response.AuthLoginResp;
import com.vova.phoenix.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/auth/login")
    public AuthLoginResp login(@RequestBody AuthLoginReq authLoginReq, HttpSession session) {
        var username = authLoginReq.getUsername();
        var password = authLoginReq.getPassword();
        var resp = new AuthLoginResp();
        var adminUser = authService.getAdminUserByUsername(username);
        var success = authService.login(adminUser, password);
        if (success) {
            session.setAttribute(SessionConstant.ADMIN_USER, adminUser);
        } else {
            session.setAttribute(SessionConstant.ADMIN_USER, null);
        }
        resp.setCertificate(session.getId());
        return resp;
    }

}
