package com.phoenix.message.web.model.provider;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.phoenix.message.common.dto.JsonColumn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "账号配置")
public class TaskConfigAccountConfig implements JsonColumn {
    @JsonProperty("sender")
    @ApiModelProperty(value = "发件人")
    private String sender;
}
