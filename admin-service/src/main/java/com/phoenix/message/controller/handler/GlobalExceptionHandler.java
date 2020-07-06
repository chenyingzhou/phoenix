package com.phoenix.message.controller.handler;

import com.phoenix.message.controller.handler.exception.BizException;
import com.phoenix.message.model.dto.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value= BizException.class)
    public BaseResponse<Object> bizExceptionHandler(BizException e){
        return new BaseResponse<>(){{
            setCode(e.getCode());
            setMsg(e.getMessage());
        }};
    }

    @ExceptionHandler(value=Exception.class)
    public BaseResponse<Object> exceptionHandler(Exception e){
        return new BaseResponse<>(){{
            setCode(-1);
            setMsg(e.getMessage());
        }};
    }
}