package com.vova.phoenix.model.dto.response.auth;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LoginResp implements Serializable {
    private String certificate;
}
