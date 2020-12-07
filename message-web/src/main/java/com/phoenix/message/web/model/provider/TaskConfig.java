package com.phoenix.message.web.model.provider;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "推送任务配置")
public class TaskConfig {
    @JsonProperty("id")
    @ApiModelProperty(value = "ID", position = 10)
    private Integer id;

    @JsonProperty("name")
    @ApiModelProperty(value = "任务名", position = 20)
    private String name;

    @JsonProperty("type")
    @ApiModelProperty(value = "类型(1:推送,2:邮件)", position = 30)
    private Integer type;

    @JsonProperty("classification")
    @ApiModelProperty(value = "用途(0:未知,1:营销,2:功能)", position = 40)
    private Integer classification;

    @JsonProperty("app_name")
    @ApiModelProperty(value = "应用名", position = 50)
    private String appName;

    @JsonProperty("user_config")
    @ApiModelProperty(value = "用户来源配置", position = 60)
    private TaskConfigUserConfig userConfig;

    @JsonProperty("content_config")
    @ApiModelProperty(value = "内容配置", position = 70)
    private TaskConfigContentConfig contentConfig;

    @JsonProperty("account_config")
    @ApiModelProperty(value = "账号配置", position = 80)
    private TaskConfigAccountConfig accountConfig;

    @JsonProperty("version_config")
    @ApiModelProperty(value = "版本配置", position = 90)
    private TaskConfigVersionConfig versionConfig;

    @JsonProperty("priority")
    @ApiModelProperty(value = "优先级", position = 100)
    private Integer priority;

    @JsonProperty("notes")
    @ApiModelProperty(value = "备注", position = 110)
    private String notes;

    @JsonProperty("period")
    @ApiModelProperty(value = "重复周期(-2:每年重复,-1:每月重复,0:不重复,>0:以实际数字按天重复)", position = 120)
    private Integer period;

    @JsonProperty("use_timezone")
    @ApiModelProperty(value = "是否按时区发送", position = 130)
    private Boolean useTimezone;

    @JsonProperty("send_time")
    @ApiModelProperty(value = "执行时间(设置)", position = 140)
    private Integer sendTime;

    @JsonProperty("record_time")
    @ApiModelProperty(value = "记录时间(执行时更新)", position = 150)
    private Integer recordTime;

    @JsonProperty("start_time")
    @ApiModelProperty(value = "有效期起始", position = 160)
    private Integer startTime;

    @JsonProperty("end_time")
    @ApiModelProperty(value = "有效期结束", position = 170)
    private Integer endTime;

    @JsonProperty("status")
    @ApiModelProperty(value = "状态(0:已就绪,1:执行中,2:已完成,3:已终止)", position = 180)
    private Integer status;

    @JsonProperty("create_time")
    @ApiModelProperty(value = "创建时间", position = 190)
    private Integer createTime;

    @JsonProperty("update_time")
    @ApiModelProperty(value = "更新时间", position = 200)
    private Integer updateTime;
}