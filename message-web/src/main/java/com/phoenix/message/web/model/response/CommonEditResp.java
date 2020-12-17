package com.phoenix.message.web.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "通用新增/修改Resp")
public class CommonEditResp {
    @JsonProperty("id")
    @ApiModelProperty(value = "ID")
    private Integer id;
}