package com.vova.phoenix.model.dto.response.auth;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginResp implements Serializable {
    private String token;
}
