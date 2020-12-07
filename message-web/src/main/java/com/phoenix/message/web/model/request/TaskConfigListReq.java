package com.phoenix.message.web.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "任务配置列表请求参数")
public class TaskConfigListReq {
    @JsonProperty("current")
    @ApiModelProperty(value = "当前页码")
    private Integer current;

    @JsonProperty("size")
    @ApiModelProperty(value = "每页数量")
    private Integer size;

    @JsonProperty("id")
    @ApiModelProperty(value = "ID")
    private Integer id;

    @JsonProperty("type")
    @ApiModelProperty(value = "类型(1:推送,2:邮件)")
    private Integer type;

    @JsonProperty("classification")
    @ApiModelProperty(value = "用途(0:未知,1:营销,2:功能)")
    private Integer classification;

    @JsonProperty("app_name")
    @ApiModelProperty(value = "应用名", name = "app_name")
    private String appName;

    @JsonProperty("status")
    @ApiModelProperty(value = "状态(0:已就绪,1:执行中,2:已完成,3:已终止)")
    private Integer status;

    @JsonProperty("create_time_start")
    @ApiModelProperty(value = "创建时间(起始)", name = "create_time_start")
    private Integer createTimeStart;

    @JsonProperty("create_time_end")
    @ApiModelProperty(value = "创建时间(结束)", name = "create_time_end")
    private Integer createTimeEnd;

}