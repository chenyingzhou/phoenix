package com.phoenix.message.common.dao;

import com.phoenix.message.common.util.SpringContextUtil;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BaseDao {

    Map<String, Mapper<?>> entityMapperMap = new HashMap<>();

    static <T> Mapper<T> getMapper(Class<?> tClass) {
        String tClassName = tClass.getSimpleName();
        Mapper<?> mapper = entityMapperMap.get(tClassName);
        if (null == mapper) {
            String mapperName = tClassName.substring(0, 1).toLowerCase() + tClassName.substring(1) + "Mapper";
            mapper = (Mapper<?>) SpringContextUtil.getBean(mapperName);
            entityMapperMap.put(tClassName, mapper);
        }
        return (Mapper<T>) mapper;
    }

    default <T> T selectOne(T entity) {
        Mapper<T> mapper = getMapper(entity.getClass());
        return mapper.selectOne(entity);
    }

    default <T> List<T> select(T entity) {
        Mapper<T> mapper = getMapper(entity.getClass());
        return mapper.select(entity);
    }

    default <T> List<T> selectByList(Class<T> tClass, String column, List<?> values, Object... columnValues) {
        Mapper<T> mapper = getMapper(tClass);
        Example example = new Example(tClass);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn(column, values);
        for (int i = 1; i < columnValues.length; i += 2) {
            Object extraColumn = columnValues[i - 1];
            Object extraValues = columnValues[i];
            if (extraColumn instanceof String && extraValues instanceof Iterable)
                criteria.andIn((String) extraColumn, (Iterable<?>) extraValues);
        }
        return mapper.selectByExample(example);
    }
}
