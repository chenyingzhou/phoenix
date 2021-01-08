package com.phoenix.message.common.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDto {
    private Integer id;

    private Integer configId;

    private Integer timeOffset;

    private LocalDateTime sendTime;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
