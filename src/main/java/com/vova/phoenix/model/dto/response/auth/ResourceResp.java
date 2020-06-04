package com.vova.phoenix.model.dto.response.auth;

import lombok.Data;

import java.util.List;

@Data
public class ResourceResp {
    private List<String> appPlatformList;
    private List<String> messageTypeList;
}
