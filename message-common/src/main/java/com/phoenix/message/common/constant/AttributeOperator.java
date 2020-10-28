package com.phoenix.message.common.constant;

public enum AttributeOperator {
    LESS_THAN("lt"),
    LESS_THAN_OR_EQUAL_TO("le"),
    EQUAL_TO("eq"),
    NOT_EQUAL_TO("ne"),
    GREATER_THAN_OR_EQUAL_TO("ge"),
    GREATER_THAN("gt"),
    IN("in"),
    LIKE("like");

    private final String code;

    AttributeOperator(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
