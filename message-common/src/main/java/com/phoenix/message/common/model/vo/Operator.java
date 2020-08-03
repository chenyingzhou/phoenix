package com.phoenix.message.common.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Operator implements Serializable {
    private Integer id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 管理员
     */
    private Integer admin;

    /**
     * 邮箱
     */
    private String email;

    /**
     * vova/airyclub
     */
    private List<String> appPlatformList;

    /**
     * push/coupon
     */
    private List<String> messageTypeList;

    public Boolean isAdmin() {
        return admin > 0;
    }

}