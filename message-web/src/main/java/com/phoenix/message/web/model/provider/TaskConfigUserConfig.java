package com.phoenix.message.web.model.provider;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.phoenix.message.common.dto.JsonColumn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "用户来源配置")
public class TaskConfigUserConfig implements JsonColumn {
    @JsonProperty("gender")
    @ApiModelProperty(value = "性别")
    private List<String> gender;

    @JsonProperty("region_code")
    @ApiModelProperty(value = "地区编码")
    private List<String> regionCode;
}
