package com.phoenix.message.common.filter.base;

public class ColumnFilter {
    private final String column;
    private final String operator;
    private final Object value;

    public ColumnFilter(String column, String operator, Object value) {
        this.column = column;
        this.operator = operator;
        this.value = value;
    }

    public String getColumn() {
        return column;
    }

    public String getOperator() {
        return operator;
    }

    public Object getValue() {
        return value;
    }
}
