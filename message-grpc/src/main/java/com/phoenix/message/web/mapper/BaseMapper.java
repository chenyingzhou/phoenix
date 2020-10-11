package com.phoenix.message.web.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface BaseMapper {
    default Date stringToDate(String stringDate) throws ParseException {
        return stringDate != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDate) : null;
    }
}
