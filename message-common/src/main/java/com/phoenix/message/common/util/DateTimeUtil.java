package com.phoenix.message.common.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public final class DateTimeUtil {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String format(LocalDateTime localDateTime) {
        return localDateTime.format(dateTimeFormatter);
    }

    public static LocalDateTime parse(String text) {
        return LocalDateTime.parse(text, dateTimeFormatter);
    }

    public static Long toTimestamp(LocalDateTime localDateTime) {
        return localDateTime.toEpochSecond(ZoneOffset.UTC);
    }

    public static LocalDateTime parseTimestamp(Long timestamp) {
        return LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.UTC);
    }
}
