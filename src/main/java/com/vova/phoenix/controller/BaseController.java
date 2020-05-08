package com.vova.phoenix.controller;

import com.vova.phoenix.model.dto.BaseResponse;
import com.vova.phoenix.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BaseController {
    @Autowired
    protected AuthService authService;

    protected <T> BaseResponse<T> sendData(T data) {
        return new BaseResponse<>() {{
            setCode(0);
            setMsg("");
            setData(data);
        }};
    }

    protected BaseResponse<Object> sendOk(String msg) {
        return new BaseResponse<>() {{
            setCode(0);
            setMsg(msg);
        }};
    }

    protected BaseResponse<Object> sendOk() {
        return sendOk("");
    }

}
