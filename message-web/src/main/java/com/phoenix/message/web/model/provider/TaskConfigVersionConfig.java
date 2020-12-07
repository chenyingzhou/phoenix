package com.phoenix.message.web.model.provider;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.phoenix.message.common.dto.JsonColumn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "版本配置")
public class TaskConfigVersionConfig implements JsonColumn {
    @JsonProperty("ios_min")
    @ApiModelProperty(value = "iOS最低版本", position = 10)
    private String iosMin;

    @JsonProperty("ios_max")
    @ApiModelProperty(value = "iOS最高版本", position = 20)
    private String iosMax;

    @JsonProperty("android_min")
    @ApiModelProperty(value = "Android最低版本", position = 30)
    private String androidMin;

    @JsonProperty("android_max")
    @ApiModelProperty(value = "Android最高版本", position = 40)
    private String androidMax;
}
