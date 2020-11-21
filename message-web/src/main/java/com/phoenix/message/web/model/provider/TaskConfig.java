package com.phoenix.message.web.model.provider;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskConfig {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private Integer type;

    @JsonProperty("classification")
    private Integer classification;

    @JsonProperty("app_name")
    private String appName;

    @JsonProperty("user_config")
    private TaskConfigUserConfig userConfig;

    @JsonProperty("content_config")
    private TaskConfigContentConfig contentConfig;

    @JsonProperty("account_config")
    private TaskConfigAccountConfig accountConfig;

    @JsonProperty("version_config")
    private TaskConfigVersionConfig versionConfig;

    @JsonProperty("priority")
    private Integer priority;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("period")
    private Integer period;

    @JsonProperty("use_timezone")
    private Boolean useTimezone;

    @JsonProperty("send_time")
    private Integer sendTime;

    @JsonProperty("record_time")
    private Integer recordTime;

    @JsonProperty("start_time")
    private Integer startTime;

    @JsonProperty("end_time")
    private Integer endTime;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("create_time")
    private Integer createTime;

    @JsonProperty("update_time")
    private Integer updateTime;
}