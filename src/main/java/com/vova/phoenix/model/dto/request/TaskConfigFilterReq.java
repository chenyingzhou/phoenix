package com.vova.phoenix.model.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class TaskConfigFilterReq implements Serializable {
    private String appPlatform;

    private Integer taskType;

}
