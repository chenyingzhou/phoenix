package com.phoenix.message.common.service.impl;

import com.phoenix.message.common.dao.AuthDao;
import com.phoenix.message.common.entity.AuthRole;
import com.phoenix.message.common.entity.AuthUser;
import com.phoenix.message.common.entity.AuthUserRole;
import com.phoenix.message.common.service.AuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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
    public List<AuthRole> findRoleListByUserId(Integer userId) {
        AuthUserRole authUserRoleExample = new AuthUserRole();
        authUserRoleExample.setUserId(userId);

        List<AuthUserRole> authUserRoleList = authDao.select(authUserRoleExample);
        List<Integer> authRoleIdList = authUserRoleList.stream()
                .map(AuthUserRole::getId)
                .collect(Collectors.toList());

        List<AuthRole> allAuthRole = findAllRole();
        return allAuthRole.stream()
                .filter(authRole -> authRoleIdList.contains(authRole.getId()))
                .collect(Collectors.toList());
    }

}
