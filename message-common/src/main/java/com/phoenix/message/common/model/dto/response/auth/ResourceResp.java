package com.phoenix.message.common.model.dto.response.auth;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResourceResp implements Serializable {
    private List<String> appPlatformList;
    private List<String> messageTypeList;
}
