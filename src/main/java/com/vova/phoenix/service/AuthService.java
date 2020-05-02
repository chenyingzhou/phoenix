package com.vova.phoenix.service;

import com.vova.phoenix.dao.AdminNodeMapper;
import com.vova.phoenix.dao.AdminUserMapper;
import com.vova.phoenix.model.repository.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AdminNodeMapper adminNodeMapper;

    @Autowired
    private AdminUserMapper adminUserMapper;

    public AdminUser getAdminUserById(Integer id) {
        return adminUserMapper.selectOneById(id);
    }

    public AdminUser getAdminUserByUsername(String username) {
        return adminUserMapper.selectOneByUsername(username);
    }

    public boolean login(AdminUser adminUser, String password) {
        return adminUser.getPassword().equals(password);
    }
}
