package com.vova.phoenix.model.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class AuthResourceResp {
    private List<String> appPlatformList;
    private List<String> messageTypeList;
}
