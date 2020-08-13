package com.phoenix.message.common.service.impl;

import com.phoenix.message.common.entity.AuthRole;
import com.phoenix.message.common.entity.AuthUser;
import com.phoenix.message.common.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AuthServiceImpl implements AuthService {

    private final AuthService dbService;

    @Autowired
    public AuthServiceImpl(@Qualifier("dbAuthService") AuthService dbService) {
        this.dbService = dbService;
    }

    @Override
    public AuthUser loadUserByUsername(String username) {
        return dbService.loadUserByUsername(username);
    }

    @Override
    public List<AuthRole> findAllRole() {
        return dbService.findAllRole();
    }

    @Override
    public List<AuthRole> findRoleListByUserId(Integer userId) {
        return dbService.findRoleListByUserId(userId);
    }

}
