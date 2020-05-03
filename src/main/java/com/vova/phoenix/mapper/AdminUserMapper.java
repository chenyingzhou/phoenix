package com.vova.phoenix.mapper;

import com.vova.phoenix.model.repository.AdminUser;
import tk.mybatis.mapper.common.Mapper;

public interface AdminUserMapper extends Mapper<AdminUser> {
    AdminUser selectOneById(Integer id);
    AdminUser selectOneByName(String name);
}