package com.phoenix.message.proto;

import com.google.protobuf.Int32Value;
import com.google.protobuf.Int64Value;
import com.google.protobuf.StringValue;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public interface WrapperConverter {
    // Int32Value与Boolean/Integer/Long/LocalDateTime互转
    default Int32Value boolean2Int32Value(Boolean value) {
        if (value == null) return null;
        return Int32Value.of(value ? 1 : 0);
    }

    default Boolean int32Value2Boolean(Int32Value value) {
        if (value == null) return null;
        return value.getValue() != 0;
    }

    default Int32Value integer2Int32Value(Integer value) {
        if (value == null) return null;
        return Int32Value.of(value);
    }

    default Integer int32Value2Integer(Int32Value value) {
        if (value == null) return null;
        return value.getValue();
    }

    default Int32Value long2Int32Value(Long value) {
        if (value == null) return null;
        return Int32Value.of(value.intValue());
    }

    default Long int32Value2Long(Int32Value value) {
        if (value == null) return null;
        return (long) value.getValue();
    }

    default Int32Value localDateTime2Int32Value(LocalDateTime value) {
        if (value == null) return null;
        return Int32Value.of((int) value.toEpochSecond(ZoneOffset.UTC));
    }

    default LocalDateTime int32Value2LocalDateTime(Int32Value value) {
        if (value == null) return null;
        return LocalDateTime.ofEpochSecond(value.getValue(), 0, ZoneOffset.UTC);
    }

    // Int64Value与Boolean/Integer/Long/LocalDateTime互转
    default Int64Value boolean2Int64Value(Boolean value) {
        if (value == null) return null;
        return Int64Value.of(value ? 1 : 0);
    }

    default Boolean int64Value2Boolean(Int64Value value) {
        if (value == null) return null;
        return value.getValue() != 0L;
    }

    default Int64Value integer2Int64Value(Integer value) {
        if (value == null) return null;
        return Int64Value.of(value.longValue());
    }

    default Integer int64Value2Integer(Int64Value value) {
        if (value == null) return null;
        return (int) value.getValue();
    }

    default Int64Value long2Int64Value(Long value) {
        if (value == null) return null;
        return Int64Value.of(value);
    }

    default Long int64Value2Long(Int64Value value) {
        if (value == null) return null;
        return value.getValue();
    }

    default Int64Value localDateTime2Int64Value(LocalDateTime value) {
        if (value == null) return null;
        return Int64Value.of(value.toEpochSecond(ZoneOffset.UTC));
    }

    default LocalDateTime int64Value2LocalDateTime(Int64Value value) {
        if (value == null) return null;
        return LocalDateTime.ofEpochSecond(value.getValue(), 0, ZoneOffset.UTC);
    }

    // StringValue与String互转
    default StringValue String2StringValue(String value) {
        if (value == null) return null;
        return StringValue.of(value);
    }

    default String int64Value2Long(StringValue value) {
        if (value == null) return null;
        return value.getValue();
    }

}
