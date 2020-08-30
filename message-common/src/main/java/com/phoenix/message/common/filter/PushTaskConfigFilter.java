package com.phoenix.message.common.filter;

import lombok.Data;

import java.util.Date;

@Data
public class PushTaskConfigFilter {
    private Integer id;
    private String appName;
    private Integer type;
    private Integer status;
    private Date createTimeB;
    private Date createTimeE;
}
