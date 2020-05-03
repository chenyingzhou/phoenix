package com.vova.phoenix.service;

import com.vova.phoenix.mapper.AdminNodeMapper;
import com.vova.phoenix.mapper.AdminUserMapper;
import com.vova.phoenix.model.repository.AdminUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthService {
    @Resource
    private AdminNodeMapper adminNodeMapper;

    @Resource
    private AdminUserMapper adminUserMapper;

    public AdminUser findAdminUserById(Integer id) {
        return adminUserMapper.selectOneById(id);
    }

    public AdminUser findAdminUserByUsername(String username) {
        return adminUserMapper.selectOneByName(username);
    }

    public boolean login(AdminUser adminUser, String password) {
        return adminUser.getPassword().equals(password);
    }
}
