package com.phoenix.message.service.impl;

import com.phoenix.message.constant.StatusConstant;
import com.phoenix.message.model.po.entity.AdminNode;
import com.phoenix.message.model.po.entity.AdminUser;
import com.phoenix.message.model.po.entity.AdminUserNode;
import com.phoenix.message.model.vo.AuthMenu;
import com.phoenix.message.service.AuthService;
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
    public AdminUser findAdminUser(Integer id) {
        return dbService.findAdminUser(id);
    }

    @Override
    public List<AdminUser> findAdminUserList(List<Integer> idList) {
        return dbService.findAdminUserList(idList);
    }

    @Override
    public AdminUser findAdminUserByUsername(String username) {
        return dbService.findAdminUserByUsername(username);
    }

    @Override
    public List<AdminNode> findAllAdminNode() {
        return dbService.findAllAdminNode();
    }

    @Override
    public List<AdminNode> findAdminNodeList(List<Integer> idList) {
        return dbService.findAdminNodeList(idList);
    }

    @Override
    public AdminUserNode findAdminUserNodeByUserId(Integer userId) {
        return dbService.findAdminUserNodeByUserId(userId);
    }

    public boolean login(AdminUser adminUser, String password) {
        return adminUser.getPassword().equals(password);
    }

    public AuthMenu adminNodeList2AuthMenuTree(List<AdminNode> adminNodeList, AuthMenu authMenuRoot) {
        for (var adminNode : adminNodeList) {
            if (adminNode.getStatus() < StatusConstant.ENABLED) {
                continue;
            }
            // 应用自身属性
            if (authMenuRoot.getId().equals(adminNode.getId())) {
                authMenuRoot.setCode(adminNode.getCode());
                authMenuRoot.setName(adminNode.getName());
                authMenuRoot.setParentId(adminNode.getParentId());
                authMenuRoot.setStatus(adminNode.getStatus());
            }
            // 添加子节点
            if (authMenuRoot.getId().equals(adminNode.getParentId())) {
                var child = new AuthMenu();
                child.setId(adminNode.getId());
                child.setCode(adminNode.getCode());
                child.setName(adminNode.getName());
                child.setParentId(adminNode.getParentId());
                child.setStatus(adminNode.getStatus());
                child = adminNodeList2AuthMenuTree(adminNodeList, child);
                authMenuRoot.getChildren().add(child);
            }
        }
        return authMenuRoot;
    }
}
