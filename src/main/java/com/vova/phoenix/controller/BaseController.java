package com.vova.phoenix.controller;

import com.vova.phoenix.model.dto.BaseResponse;
import com.vova.phoenix.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @Autowired
    protected AuthService authService;

    protected <T> BaseResponse<T> sendData(T data) {
        var response = new BaseResponse<T>();
        response.setCode(0);
        response.setMsg("");
        response.setData(data);
        return response;
    }

    protected <T> BaseResponse<T> sendOk(String msg) {
        var response = new BaseResponse<T>();
        response.setCode(0);
        response.setMsg(msg);
        return response;
    }

    protected <T> BaseResponse<T> sendOk() {
        return sendOk("");
    }

    protected <T> BaseResponse<T> sendFail(String msg, Integer code) {
        var response = new BaseResponse<T>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    protected <T> BaseResponse<T> sendFail(String msg) {
        return sendFail(msg, -1);
    }

    protected <T> BaseResponse<T> sendFail() {
        return sendFail("");
    }

}
