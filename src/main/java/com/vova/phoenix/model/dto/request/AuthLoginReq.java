package com.vova.phoenix.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthLoginReq {
    private String username;
    private String password;
}
