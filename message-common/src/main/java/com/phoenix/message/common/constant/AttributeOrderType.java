package com.phoenix.message.common.constant;

public enum AttributeOrderType {
    ASC("asc"),
    DESC("desc");

    private final String code;

    AttributeOrderType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
