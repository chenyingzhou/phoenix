package com.phoenix.message.web.controller;

import com.phoenix.message.web.model.BaseResponse;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BaseController {

    protected <T> BaseResponse<T> sendData(T data) {
        BaseResponse<T> resp = new BaseResponse<T>();
        resp.setCode(0);
        resp.setMsg("");
        resp.setData(data);
        return resp;
    }

    protected BaseResponse<?> sendOk() {
        var resp = new BaseResponse<>();
        resp.setCode(0);
        resp.setMsg("");
        return resp;
    }

}
