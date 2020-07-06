package com.phoenix.message.model.dto.response.auth;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginResp implements Serializable {
    private String token;
}
