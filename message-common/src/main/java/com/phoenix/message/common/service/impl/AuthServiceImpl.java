package com.phoenix.message.common.service.impl;

import com.phoenix.message.common.beanutil.CachedBeanCopier;
import com.phoenix.message.common.dao.AuthDao;
import com.phoenix.message.common.dto.AuthRoleTree;
import com.phoenix.message.common.entity.*;
import com.phoenix.message.common.service.AuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthDao authDao;

    @Override
    public AuthUser loadUserByUsername(String username) {
        AuthUser authUserExample = new AuthUser();
        authUserExample.setUsername(username);
        authUserExample.setStatus(AuthService.AUTH_USER_STATUS_NORMAL);
        return authDao.selectOne(authUserExample);
    }

    @Override
    public List<AuthRole> findAllRole() {
        return authDao.select(new AuthRole());
    }

    @Override
    public AuthRoleTree authRoleListToTree(List<AuthRole> authRoleList, AuthRoleTree authRoleTree) {
        if (authRoleTree.getId() == null) {
            authRoleTree.setId(0);
        }
        List<AuthRole> childAuthRoleList = authRoleList.stream()
                .filter(authRole -> authRole.getParentId().equals(authRoleTree.getId()))
                .collect(Collectors.toList());
        for (AuthRole authRole : childAuthRoleList) {
            AuthRoleTree childAuthRoleTree = CachedBeanCopier.copy(authRole, new AuthRoleTree());
            authRoleListToTree(authRoleList, childAuthRoleTree);
            authRoleTree.getChildren().add(childAuthRoleTree);
        }
        return authRoleTree;
    }

    @Override
    public List<AuthRole> findRoleListByUserId(Integer userId) {
        AuthUserRole authUserRoleExample = new AuthUserRole();
        authUserRoleExample.setUserId(userId);

        List<AuthUserRole> authUserRoleList = authDao.select(authUserRoleExample);
        List<Integer> authRoleIdList = authUserRoleList.stream()
                .map(AuthUserRole::getRoleId)
                .collect(Collectors.toList());

        List<AuthRole> allAuthRole = findAllRole();
        return allAuthRole.stream()
                .filter(authRole -> authRoleIdList.contains(authRole.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthResource> findAllResource() {
        return authDao.select(new AuthResource());
    }

    @Override
    public Map<String, List<AuthResource>> findResourceMapByUserId(Integer userId) {
        AuthUserResource authUserResourceExample = new AuthUserResource();
        authUserResourceExample.setUserId(userId);

        List<AuthUserResource> authUserResourceList = authDao.select(authUserResourceExample);
        List<Integer> authResourceIdList = authUserResourceList.stream()
                .map(AuthUserResource::getResourceId)
                .collect(Collectors.toList());

        List<AuthResource> allAuthResource = findAllResource();
        return allAuthResource.stream()
                .filter(authResource -> authResourceIdList.contains(authResource.getId()))
                .collect(Collectors.groupingBy(AuthResource::getType));
    }

}
