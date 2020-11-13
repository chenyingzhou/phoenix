package com.phoenix.message.common.dto;

import com.phoenix.message.common.dto.taskconfig.TaskConfigAccountConfigDto;
import com.phoenix.message.common.dto.taskconfig.TaskConfigContentConfigDto;
import com.phoenix.message.common.dto.taskconfig.TaskConfigUserConfigDto;
import com.phoenix.message.common.dto.taskconfig.TaskConfigVersionConfigDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class TaskConfigDto {
    private Integer id;

    private String name;

    private Integer type;

    private Integer classification;

    private String appName;

    private TaskConfigUserConfigDto userConfig;

    private TaskConfigContentConfigDto contentConfig;

    private TaskConfigAccountConfigDto accountConfig;

    private TaskConfigVersionConfigDto versionConfig;

    private Integer priority;

    private String notes;

    private Integer period;

    private Boolean useTimezone;

    private LocalDateTime sendTime;

    private LocalDateTime recordTime;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
