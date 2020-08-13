package com.phoenix.message.common.service;

import com.phoenix.message.common.entity.AuthRole;
import com.phoenix.message.common.entity.AuthUser;
import com.phoenix.message.common.model.po.entity.AdminNode;
import com.phoenix.message.common.model.po.entity.AdminUser;
import com.phoenix.message.common.model.po.entity.AdminUserNode;
import com.phoenix.message.common.model.vo.AuthMenu;

import java.util.List;

public interface AuthService {
    Integer AUTH_USER_STATUS_NORMAL = 0;
    Integer AUTH_USER_STATUS_DISABLED = 1;

    AuthUser loadUserByUsername(String username);

    List<AuthRole> findAllRole();

    List<AuthRole> findRoleListByUserId(Integer userId);

    public AdminUser findAdminUser(Integer id);

    public List<AdminUser> findAdminUserList(List<Integer> idList);

    public AdminUser findAdminUserByUsername(String username);

    public List<AdminNode> findAllAdminNode();

    public List<AdminNode> findAdminNodeList(List<Integer> idList);

    public AdminUserNode findAdminUserNodeByUserId(Integer userId);

    public boolean login(AdminUser adminUser, String password);

    public AuthMenu adminNodeList2AuthMenuTree(List<AdminNode> adminNodeList, AuthMenu authMenuRoot);
}
