package com.phoenix.message.web.model;

import lombok.Data;

@Data
public class FindTaskConfigResp {
    private Integer code;
    private String msg;
    private PaginationResult data;
}
