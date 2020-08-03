package com.phoenix.message.common.model.converter.p2v;

import com.phoenix.message.common.model.po.entity.AdminUser;
import com.phoenix.message.common.model.vo.Operator;
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
        operator.setAppPlatformList(source.getAppPlatformList());
        operator.setMessageTypeList(source.getMessageTypeList());
        return operator;
    }
}
