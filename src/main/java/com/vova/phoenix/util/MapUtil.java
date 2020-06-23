package com.vova.phoenix.util;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {

    public static Map<String, Object> toLowerCamelKeys(Map<String, Object> srcMap) {
        var destMap = new HashMap<String, Object>();
        if (!CollectionUtils.isEmpty(srcMap)) {
            for (Map.Entry<String, Object> entry : srcMap.entrySet()) {
                destMap.put(StringUtil.underlineToCamel(entry.getKey()), entry.getValue());
            }
        }
        return destMap;
    }

}
