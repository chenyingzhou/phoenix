package com.vova.phoenix.model.converter;

import com.vova.phoenix.model.converter.p2v.AdminUser2Operator;
import com.vova.phoenix.model.repository.AdminUser;
import com.vova.phoenix.model.vo.Operator;
import org.springframework.core.convert.converter.Converter;

/**
 * 用于将 po 转为 vo
 */
public class P2V {
    public static final Converter<AdminUser, Operator> ADMIN_USER_2_OPERATOR = new AdminUser2Operator();
}
