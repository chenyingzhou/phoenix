package com.vova.phoenix.model.converter.p2v;

import com.alibaba.fastjson.JSON;
import com.vova.phoenix.model.po.entity.AdminUser;
import com.vova.phoenix.model.vo.Operator;
import org.springframework.core.convert.converter.Converter;

import javax.validation.constraints.NotNull;

public class AdminUser2Operator implements Converter<AdminUser, Operator> {

    @Override
    public Operator convert(@NotNull AdminUser source) {
        var operator = new Operator();
        operator.setId(source.getId());
        operator.setName(source.getName());
        operator.setRealName(source.getRealName());
        operator.setAdmin(source.getAdmin());
        operator.setEmail(source.getEmail());
        operator.setAppPlatformList(JSON.parseArray(source.getAppPlatformList(), String.class));
        operator.setMessageTypeList(JSON.parseArray(source.getMessageTypeList(), String.class));
        return operator;
    }
}