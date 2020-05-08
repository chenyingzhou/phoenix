package com.vova.phoenix.controller;

import com.vova.phoenix.constant.SessionConstant;
import com.vova.phoenix.controller.handler.exception.BizException;
import com.vova.phoenix.model.dto.BaseResponse;
import com.vova.phoenix.model.dto.request.AuthLoginReq;
import com.vova.phoenix.model.dto.response.AuthLoginResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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
    public BaseResponse<Object> menu(HttpSession session) {
        return sendOk("啥也没有");
    }

}
