package com.phoenix.message.web.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
}
