package com.vova.phoenix.model.dto;

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
        private List<T> list = new ArrayList<>();
    }
}
