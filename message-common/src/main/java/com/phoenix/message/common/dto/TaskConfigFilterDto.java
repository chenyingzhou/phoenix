package com.phoenix.message.common.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class TaskConfigFilterDto {
    private Long current;

    private Long size;

    private Integer id;

    private Integer type;

    private Integer classification;

    private String appName;

    private Integer status;

    private LocalDateTime createTimeStart;

    private LocalDateTime createTimeEnd;

}
