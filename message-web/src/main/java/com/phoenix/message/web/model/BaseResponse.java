package com.phoenix.message.web.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ApiModel
public class BaseResponse<T> implements Serializable {
    @ApiModelProperty(position = 1)
    private Integer code;
    @ApiModelProperty(position = 2)
    private String msg;
    @ApiModelProperty(position = 3)
    private T data;

    @Data
    @ApiModel
    public static class Pagination<T> {
        @ApiModelProperty(position = 1)
        private long current;
        @ApiModelProperty(position = 2)
        private long size;
        @ApiModelProperty(position = 3)
        private long total;
        @ApiModelProperty(position = 4)
        private List<T> records;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }
}
