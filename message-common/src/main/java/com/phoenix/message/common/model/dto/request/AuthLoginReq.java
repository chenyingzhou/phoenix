package com.phoenix.message.common.model.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthLoginReq implements Serializable {
    private String username;
    private String password;
}
