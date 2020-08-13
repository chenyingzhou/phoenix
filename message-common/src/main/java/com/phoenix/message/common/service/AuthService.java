package com.phoenix.message.common.service;

import com.phoenix.message.common.entity.AuthRole;
import com.phoenix.message.common.entity.AuthUser;

import java.util.List;

public interface AuthService {
    Integer AUTH_USER_STATUS_NORMAL = 0;
    Integer AUTH_USER_STATUS_DISABLED = 1;

    AuthUser loadUserByUsername(String username);

    List<AuthRole> findAllRole();

    List<AuthRole> findRoleListByUserId(Integer userId);

}
