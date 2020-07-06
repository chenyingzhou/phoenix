package com.phoenix.message.service;

import com.phoenix.message.model.po.entity.AdminNode;
import com.phoenix.message.model.po.entity.AdminUser;
import com.phoenix.message.model.po.entity.AdminUserNode;
import com.phoenix.message.model.vo.AuthMenu;

import java.util.List;

public interface AuthService {
    public AdminUser findAdminUser(Integer id);

    public List<AdminUser> findAdminUserList(List<Integer> idList);

    public AdminUser findAdminUserByUsername(String username);

    public List<AdminNode> findAllAdminNode();

    public List<AdminNode> findAdminNodeList(List<Integer> idList);

    public AdminUserNode findAdminUserNodeByUserId(Integer userId);

    public boolean login(AdminUser adminUser, String password);

    public AuthMenu adminNodeList2AuthMenuTree(List<AdminNode> adminNodeList, AuthMenu authMenuRoot);
}
