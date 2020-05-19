package com.vova.phoenix.controller;

import com.vova.phoenix.model.dto.BaseListResponse;
import com.vova.phoenix.model.dto.BaseResponse;
import com.vova.phoenix.service.AuthService;
import com.vova.phoenix.service.TaskService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public abstract class BaseController {
    @Resource
    protected AuthService authService;

    @Resource
    protected TaskService taskService;

    protected <T> BaseResponse<T> sendData(T data) {
        var resp = new BaseResponse<T>();
        resp.setCode(0);
        resp.setMsg("");
        resp.setData(data);
        return resp;
    }

    protected <T> BaseListResponse<T> sendList(List<T> list) {
        var resp = new BaseListResponse<T>();
        resp.setCode(0);
        resp.setMsg("");
        resp.getData().setList(list);
        return resp;
    }

    protected BaseResponse<Object> sendOk(String msg) {
        var resp = new BaseResponse<>();
        resp.setCode(0);
        resp.setMsg(msg);
        return resp;
    }

    protected BaseResponse<Object> sendOk() {
        return sendOk("");
    }

}
