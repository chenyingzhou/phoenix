package com.phoenix.message.common;

import lombok.Data;

@Data
public class Pagination {
    private Integer page = 0;
    private Integer pageSize = 10;
    private Integer totalCount = 0;
    private String orderBy;
    private String orderType;
}
