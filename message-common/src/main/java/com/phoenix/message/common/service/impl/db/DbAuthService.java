package com.phoenix.message.common.service.impl.db;

import com.phoenix.message.common.entity.AuthRole;
import com.phoenix.message.common.entity.AuthUser;
import com.phoenix.message.common.entity.AuthUserRole;
import com.phoenix.message.common.mapper.AdminNodeMapper;
import com.phoenix.message.common.mapper.AdminUserMapper;
import com.phoenix.message.common.mapper.AdminUserNodeMapper;
import com.phoenix.message.common.mapper.auth.AuthRoleMapper;
import com.phoenix.message.common.mapper.auth.AuthUserMapper;
import com.phoenix.message.common.mapper.auth.AuthUserRoleMapper;
import com.phoenix.message.common.model.po.entity.AdminNode;
import com.phoenix.message.common.model.po.entity.AdminUser;
import com.phoenix.message.common.model.po.entity.AdminUserNode;
import com.phoenix.message.common.model.vo.AuthMenu;
import com.phoenix.message.common.service.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DbAuthService implements AuthService {
    @Resource
    private AuthUserMapper authUserMapper;

    @Resource
    private AuthRoleMapper authRoleMapper;

    @Resource
    private AuthUserRoleMapper authUserRoleMapper;

    @Override
    public AuthUser loadUserByUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        Example example = new Example(AuthUser.class);
        example.createCriteria().andEqualTo(AuthUser.USERNAME, username);
        AuthUser authUser = authUserMapper.selectOneByExample(example);
        if (authUser != null && authUser.getStatus().equals(AuthService.AUTH_USER_STATUS_NORMAL)) {
            return authUser;
        } else {
            return null;
        }
    }

    @Override
    public List<AuthRole> findAllRole() {
        return authRoleMapper.selectAll();
    }

    @Override
    public List<AuthRole> findRoleListByUserId(Integer userId) {
        if (userId == null) {
            return null;
        }
        Example example = new Example(AuthUserRole.class);
        example.createCriteria().andEqualTo(AuthUserRole.USER_ID, userId);
        List<AuthUserRole> authUserRoleList = authUserRoleMapper.selectByExample(example);
        List<AuthRole> authRoleList = findAllRole();
        List<Integer> authRoleIdList = authUserRoleList.stream()
                .map(AuthUserRole::getRoleId)
                .collect(Collectors.toList());
        return authRoleList.stream()
                .filter(authRole -> authRoleIdList.contains(authRole.getId()))
                .collect(Collectors.toList());
    }

    @Resource
    private AdminNodeMapper adminNodeMapper;

    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private AdminUserNodeMapper adminUserNodeMapper;

    @Override
    public AdminUser findAdminUser(Integer id) {
        if (null == id) {
            return null;
        }
        var example = new Example(AdminUser.class);
        example.createCriteria().andEqualTo(AdminUser.ID, id);
        return adminUserMapper.selectOneByExample(example);
    }

    @Override
    public List<AdminUser> findAdminUserList(List<Integer> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return new ArrayList<>();
        }
        var example = new Example(AdminUser.class);
        example.createCriteria().andIn(AdminUser.ID, idList);
        return adminUserMapper.selectByExample(example);
    }

    @Override
    public AdminUser findAdminUserByUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        var example = new Example(AdminUser.class);
        example.createCriteria().andEqualTo(AdminUser.NAME, username);
        return adminUserMapper.selectOneByExample(example);
    }

    @Override
    public List<AdminNode> findAllAdminNode() {
        return adminNodeMapper.selectAll();
    }

    @Override
    public List<AdminNode> findAdminNodeList(List<Integer> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return new ArrayList<>();
        }
        var example = new Example(AdminNode.class);
        example.createCriteria().andIn(AdminNode.ID, idList);
        return adminNodeMapper.selectByExample(example);
    }

    @Override
    public AdminUserNode findAdminUserNodeByUserId(Integer userId) {
        if (null == userId) {
            return null;
        }
        var example = new Example(AdminUserNode.class);
        example.createCriteria().andEqualTo(AdminUserNode.USER_ID, userId);
        return adminUserNodeMapper.selectOneByExample(example);
    }

    @Override
    public boolean login(AdminUser adminUser, String password) {
        return false;
    }

    @Override
    public AuthMenu adminNodeList2AuthMenuTree(List<AdminNode> adminNodeList, AuthMenu authMenuRoot) {
        return null;
    }

}
