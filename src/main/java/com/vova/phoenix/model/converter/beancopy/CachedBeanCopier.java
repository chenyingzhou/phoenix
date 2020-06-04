package com.vova.phoenix.model.converter.beancopy;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachedBeanCopier {

    private static final Map<String, BeanCopier> BEAN_COPIERS = new HashMap<>();

    public static <T> T copy(Object srcObj, T destObj) {
        String key = genKey(srcObj.getClass(), destObj.getClass());
        BeanCopier copier;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(srcObj.getClass(), destObj.getClass(), false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        copier.copy(srcObj, destObj, null);
        return destObj;
    }

    public static <T> T copy(Object srcObj, T destObj, Converter converter) {
        String key = genKey(srcObj.getClass(), destObj.getClass());
        BeanCopier copier;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(srcObj.getClass(), destObj.getClass(), true);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        copier.copy(srcObj, destObj, converter);
        return destObj;
    }

    public static <T> List<T> copy(List<?> srcObjList, Class<T> destClazz) {
        List<T> destObjList = new ArrayList<>();
        for (Object srcObj : srcObjList) {
            T destObj;
            try {
                destObj = destClazz.newInstance();
            } catch (Throwable e) {
                e.printStackTrace();
                return destObjList;
            }
            String key = genKey(srcObj.getClass(), destClazz);
            BeanCopier copier;
            if (!BEAN_COPIERS.containsKey(key)) {
                copier = BeanCopier.create(srcObj.getClass(), destClazz, false);
                BEAN_COPIERS.put(key, copier);
            } else {
                copier = BEAN_COPIERS.get(key);
            }
            copier.copy(srcObj, destObj, null);
            destObjList.add(destObj);
        }
        return destObjList;
    }

    private static String genKey(Class<?> srcClazz, Class<?> destClazz) {
        return srcClazz.getName() + destClazz.getName();
    }

}
