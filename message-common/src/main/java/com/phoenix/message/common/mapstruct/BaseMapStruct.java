package com.phoenix.message.common.mapstruct;

import com.phoenix.message.common.util.DateTimeUtil;

import java.time.LocalDateTime;

public interface BaseMapStruct {
    // LocalDateTime与Integer/Long/String互转
    default Integer localDateTime2Integer(LocalDateTime value) {
        if (value == null) return null;
        return DateTimeUtil.toTimestamp(value).intValue();
    }

    default LocalDateTime integer2LocalDateTime(Integer value) {
        if (value == null || value.equals(0)) return null;
        return DateTimeUtil.parseTimestamp(value.longValue());
    }

    default Long localDateTime2Long(LocalDateTime value) {
        if (value == null) return null;
        return DateTimeUtil.toTimestamp(value);
    }

    default LocalDateTime long2LocalDateTime(Long value) {
        if (value == null || value.equals(0L)) return null;
        return DateTimeUtil.parseTimestamp(value);
    }

    default String localDateTime2String(LocalDateTime value) {
        if (value == null) return null;
        return DateTimeUtil.format(value);
    }

    default LocalDateTime String2LocalDateTime(String value) {
        if (value == null || value.equals("")) return null;
        return DateTimeUtil.parse(value);
    }

    // Boolean/Integer/Long互转
    default Boolean integer2Boolean(Integer value) {
        if (value == null) return null;
        return !value.equals(0);
    }

    default Integer boolean2Integer(Boolean value) {
        if (value == null) return null;
        return value ? 1 : 0;
    }

    default Boolean long2Boolean(Long value) {
        if (value == null) return null;
        return !value.equals(0L);
    }

    default Long boolean2Long(Boolean value) {
        if (value == null) return null;
        return value ? 1L : 0L;
    }

    default Integer long2Integer(Long value) {
        if (value == null) return null;
        return value.intValue();
    }

    default Long integer2Long(Integer value) {
        if (value == null) return null;
        return value.longValue();
    }

}
