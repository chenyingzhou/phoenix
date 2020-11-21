package com.phoenix.message.web.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class BaseResponse<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    @Data
    public static class Pagination<T> {
        private long current;
        private long size;
        private long total;
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
