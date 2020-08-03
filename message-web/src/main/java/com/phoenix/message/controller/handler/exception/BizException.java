package com.phoenix.message.controller.handler.exception;

public class BizException extends RuntimeException {
    /**
     * 错误码
     */
    protected Integer code = -1;
    /**
     * 错误信息
     */
    protected String message;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
        this.message = message;
    }

    public BizException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}