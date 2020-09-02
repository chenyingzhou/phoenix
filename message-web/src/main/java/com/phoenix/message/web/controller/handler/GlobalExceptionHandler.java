package com.phoenix.message.web.controller.handler;

import com.phoenix.message.web.model.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.util.NestedServletException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value=Throwable.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<?> exceptionHandler(NestedServletException e){
        BaseResponse<?> response = new BaseResponse<>();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMsg(e.getCause().getMessage());
        return response;
    }
}