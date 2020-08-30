package com.phoenix.message.web.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class BaseListResponse<T> implements Serializable {
    private Integer code;
    private String msg;
    private ListModel<T> data = new ListModel<>();

    @Data
    public static class ListModel<T> implements Serializable {
        private Integer page = 0;
        private Integer pageSize = 10;
        private Integer totalCount = 0;
        private List<T> list = new ArrayList<>();
    }
}
