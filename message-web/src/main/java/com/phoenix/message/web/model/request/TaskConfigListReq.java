package com.phoenix.message.web.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskConfigListReq {
    @JsonProperty("current")
    private Integer current;

    @JsonProperty("size")
    private Integer size;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("type")
    private Integer type;

    @JsonProperty("classification")
    private Integer classification;

    @JsonProperty("app_name")
    private String appName;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("create_time_start")
    private Integer createTimeStart;

    @JsonProperty("create_time_end")
    private Integer createTimeEnd;

}