package com.phoenix.message.common.dto;

import lombok.Data;

import java.util.List;

@Data
public class Pagination<T> {
    private long current;
    private long size;
    private long total;
    private List<T> records;
}
