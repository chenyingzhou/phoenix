package com.phoenix.message.common.dao;

import com.phoenix.message.common.Pagination;
import com.phoenix.message.common.constant.SqlConstant;
import com.phoenix.message.common.filter.base.ColumnFilter;
import com.phoenix.message.common.util.SpringContextUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
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

    default <T> List<T> selectByFilter(Class<T> tClass, List<ColumnFilter> columnFilterList, Pagination pagination) {
        Mapper<T> mapper = getMapper(tClass);
        Example example = new Example(tClass);
        Example.Criteria criteria = example.createCriteria();
        for (ColumnFilter columnFilter : columnFilterList) {
            String column = columnFilter.getColumn();
            String operator = columnFilter.getOperator();
            Object value = columnFilter.getValue();
            switch (operator) {
                case SqlConstant.LT:
                    criteria.andLessThan(column, value);
                    break;
                case SqlConstant.LE:
                    criteria.andLessThanOrEqualTo(column, value);
                    break;
                case SqlConstant.EQ:
                    criteria.andEqualTo(column, value);
                    break;
                case SqlConstant.NE:
                    criteria.andNotEqualTo(column, value);
                    break;
                case SqlConstant.GE:
                    criteria.andGreaterThanOrEqualTo(column, value);
                    break;
                case SqlConstant.GT:
                    criteria.andGreaterThan(column, value);
                    break;
                case SqlConstant.IN:
                    if (value instanceof Iterable) {
                        criteria.andIn(column, (Iterable<?>) value);
                    }
                    break;
                case SqlConstant.LIKE:
                    criteria.andLike(column, value.toString());
                    break;
            }
        }

        if (pagination != null) {
            if (!StringUtils.isEmpty(pagination.getOrderBy())) {
                if (pagination.getOrderType().toUpperCase().equals(SqlConstant.ORDER_DESC)) {
                    example.orderBy(pagination.getOrderBy()).desc();
                } else {
                    example.orderBy(pagination.getOrderBy()).asc();
                }
            }
            int offset = (pagination.getPage() - 1) * pagination.getPageSize();
            int limit = pagination.getPageSize();
            RowBounds rowBounds = new RowBounds(offset, limit);
            pagination.setTotalCount(mapper.selectCountByExample(example));
            return mapper.selectByExampleAndRowBounds(example, rowBounds);
        } else {
            return mapper.selectByExample(example);
        }
    }
}
