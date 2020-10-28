package com.phoenix.message.web.model;

import lombok.Data;

import java.util.List;

@Data
public class PaginationResult {
    private Integer totalCount;
    private List<TaskConfig> list;
}
