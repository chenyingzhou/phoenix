package com.phoenix.message.web.controller.handler;

import com.phoenix.message.web.model.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value=Throwable.class)
    public BaseResponse<Object> exceptionHandler(Exception e){
        return new BaseResponse<>(){{
            setCode(-1);
            setMsg(e.getMessage());
        }};
    }
}