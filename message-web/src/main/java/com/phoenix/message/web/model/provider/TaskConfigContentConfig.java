package com.phoenix.message.web.model.provider;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.phoenix.message.common.dto.JsonColumn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "内容配置")
public class TaskConfigContentConfig implements JsonColumn {
    @JsonProperty("type")
    @ApiModelProperty(value = "类型")
    private String type;
}
