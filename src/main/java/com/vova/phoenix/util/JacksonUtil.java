package com.vova.phoenix.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JacksonUtil {

    private static final ThreadLocal<ObjectMapper> threadLocal = ThreadLocal.withInitial(
            () -> {
                var objectMapper = new ObjectMapper();
                objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return objectMapper;
            }
    );

    public static ObjectMapper getObjectMapper() {
        return threadLocal.get();
    }

    public static <T> T toObject(String jsonStr, Class<T> valueType) {
        try {
            return getObjectMapper().readValue(jsonStr, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> toList(String jsonStr, Class<T> valueType) {
        var valueList = new ArrayList<T>();
        try {
            var objectMapper = getObjectMapper();
            var objList = objectMapper.readValue(jsonStr, new TypeReference<List<Object>>() {
            });
            for (Object obj : objList) {
                valueList.add(objectMapper.convertValue(obj, valueType));
            }
            return valueList;
        } catch (Exception e) {
            valueList.clear();
            e.printStackTrace();
        }
        return valueList;
    }

    public static String toJson(Object object) {
        try {
            return getObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T transObject(Object object, Class<T> valueType) {
        return toObject(toJson(object), valueType);
    }

    public static <T> List<T> transList(List<?> objectList, Class<T> valueType) {
        return toList(toJson(objectList), valueType);
    }

}
