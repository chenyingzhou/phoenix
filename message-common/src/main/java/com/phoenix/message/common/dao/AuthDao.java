package com.phoenix.message.common.dao;

import com.phoenix.message.common.entity.AuthRole;
import com.phoenix.message.common.entity.AuthUser;
import com.phoenix.message.common.entity.AuthUserRole;

import java.util.List;

public interface AuthDao {

    AuthUser selectOne(AuthUser authUser);

    List<AuthUser> select(AuthUser authUser);

    List<AuthUser> selectAuthUserList(String column, List<?> values);

    AuthRole selectOne(AuthRole authRole);

    List<AuthRole> select(AuthRole authRole);

    List<AuthRole> selectAuthRoleList(String column, List<?> values);

    AuthUserRole selectOne(AuthUserRole authUserRole);

    List<AuthUserRole> select(AuthUserRole authUserRole);

    List<AuthUserRole> selectAuthUserRoleList(String column, List<?> values);

}
