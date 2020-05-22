package com.vova.phoenix.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            return threadLocal.get().readValue(jsonStr, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> toList(String jsonStr, Class<T> valueType) {
        var valueList = new ArrayList<T>();
        try {
            var objectMapper = threadLocal.get();
            var mapList = objectMapper.readValue(jsonStr, new TypeReference<List<Map<String, Object>>>() {
            });
            for (Map<String, Object> stringObjectMap : mapList) {
                valueList.add(objectMapper.convertValue(stringObjectMap, valueType));
            }
            return valueList;
        } catch (Exception e) {
            valueList.clear();
            e.printStackTrace();
        }
        return valueList;
    }

    public static String toJSon(Object object) {
        try {
            return threadLocal.get().writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
