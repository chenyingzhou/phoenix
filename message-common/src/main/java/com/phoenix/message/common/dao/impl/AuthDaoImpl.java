package com.phoenix.message.common.dao.impl;

import com.phoenix.message.common.dao.AuthDao;
import com.phoenix.message.common.entity.*;
import com.phoenix.message.common.mapper.auth.*;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthDaoImpl implements AuthDao {
    @Resource
    private AuthUserMapper authUserMapper;

    @Resource
    private AuthRoleMapper authRoleMapper;

    @Resource
    private AuthUserRoleMapper authUserRoleMapper;

    @Resource
    private AuthResourceMapper authResourceMapper;

    @Resource
    private AuthUserResourceMapper authUserResourceMapper;

    @Override
    public AuthUser selectOne(AuthUser authUser) {
        return authUserMapper.selectOne(authUser);
    }

    @Override
    public List<AuthUser> select(AuthUser authUser) {
        return authUserMapper.select(authUser);
    }

    @Override
    public List<AuthUser> selectAuthUserList(String column, List<?> values) {
        Example example = new Example(AuthUser.class);
        example.createCriteria().andIn(column, values);
        return authUserMapper.selectByExample(example);
    }

    @Override
    public AuthRole selectOne(AuthRole authRole) {
        return authRoleMapper.selectOne(authRole);
    }

    @Override
    public List<AuthRole> select(AuthRole authRole) {
        return authRoleMapper.select(authRole);
    }

    @Override
    public List<AuthRole> selectAuthRoleList(String column, List<?> values) {
        Example example = new Example(AuthRole.class);
        example.createCriteria().andIn(column, values);
        return authRoleMapper.selectByExample(example);
    }

    @Override
    public AuthUserRole selectOne(AuthUserRole authUserRole) {
        return authUserRoleMapper.selectOne(authUserRole);
    }

    @Override
    public List<AuthUserRole> select(AuthUserRole authUserRole) {
        return authUserRoleMapper.select(authUserRole);
    }

    @Override
    public List<AuthUserRole> selectAuthUserRoleList(String column, List<?> values) {
        Example example = new Example(AuthUserRole.class);
        example.createCriteria().andIn(column, values);
        return authUserRoleMapper.selectByExample(example);
    }

    @Override
    public AuthResource selectOne(AuthResource authResource) {
        return authResourceMapper.selectOne(authResource);
    }

    @Override
    public List<AuthResource> select(AuthResource authResource) {
        return authResourceMapper.select(authResource);
    }

    @Override
    public List<AuthResource> selectAuthResourceList(String column, List<?> values) {
        Example example = new Example(AuthResource.class);
        example.createCriteria().andIn(column, values);
        return authResourceMapper.selectByExample(example);
    }

    @Override
    public AuthUserResource selectOne(AuthUserResource authUserResource) {
        return authUserResourceMapper.selectOne(authUserResource);
    }

    @Override
    public List<AuthUserResource> select(AuthUserResource authUserResource) {
        return authUserResourceMapper.select(authUserResource);
    }

    @Override
    public List<AuthUserResource> selectAuthUserResourceList(String column, List<?> values) {
        Example example = new Example(AuthUserResource.class);
        example.createCriteria().andIn(column, values);
        return authUserResourceMapper.selectByExample(example);
    }
}
