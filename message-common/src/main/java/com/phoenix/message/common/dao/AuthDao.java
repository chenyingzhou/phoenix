package com.phoenix.message.common.dao;

import com.phoenix.message.common.entity.*;

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

    AuthResource selectOne(AuthResource authResource);

    List<AuthResource> select(AuthResource authResource);

    List<AuthResource> selectAuthResourceList(String column, List<?> values);

    AuthUserResource selectOne(AuthUserResource authUserResource);

    List<AuthUserResource> select(AuthUserResource authUserResource);

    List<AuthUserResource> selectAuthUserResourceList(String column, List<?> values);

}
