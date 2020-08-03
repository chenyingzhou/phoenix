package com.phoenix.message.common.model.converter;

import com.phoenix.message.common.model.converter.p2v.AdminUser2Operator;
import com.phoenix.message.common.model.po.entity.AdminUser;
import com.phoenix.message.common.model.vo.Operator;
import org.springframework.core.convert.converter.Converter;

/**
 * 用于将 po 转为 vo
 */
public class P2V {
    public static final Converter<AdminUser, Operator> ADMIN_USER_2_OPERATOR = new AdminUser2Operator();
}
