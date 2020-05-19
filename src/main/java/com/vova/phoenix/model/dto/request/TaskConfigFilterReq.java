package com.vova.phoenix.model.dto.request;

import lombok.Data;

@Data
public class TaskConfigFilterReq {
    private String appPlatform;

    private Byte taskType;

}
