package com.vova.phoenix.service;

import com.vova.phoenix.constant.StatusConstant;
import com.vova.phoenix.mapper.AdminNodeMapper;
import com.vova.phoenix.mapper.AdminUserMapper;
import com.vova.phoenix.mapper.AdminUserNodeMapper;
import com.vova.phoenix.model.po.entity.AdminNode;
import com.vova.phoenix.model.po.entity.AdminUser;
import com.vova.phoenix.model.po.entity.AdminUserNode;
import com.vova.phoenix.model.vo.AuthMenu;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {
    @Resource
    private AdminNodeMapper adminNodeMapper;

    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private AdminUserNodeMapper adminUserNodeMapper;

    public AdminUser findAdminUserById(Integer id) {
        if (null == id) {
            return null;
        }
        var example = new Example(AdminUser.class);
        example.createCriteria().andEqualTo(AdminUser.ID, id);
        return adminUserMapper.selectOneByExample(example);
    }

    public AdminUser findAdminUserByUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        var example = new Example(AdminUser.class);
        example.createCriteria().andEqualTo(AdminUser.NAME, username);
        return adminUserMapper.selectOneByExample(example);
    }

    public List<AdminNode> findAllAdminNode() {
        var example = new Example(AdminNode.class);
        return adminNodeMapper.selectByExample(example);
    }

    public List<AdminNode> findAdminNodeByIdList(List<Integer> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return new ArrayList<>();
        }
        var example = new Example(AdminNode.class);
        example.createCriteria().andIn(AdminNode.ID, idList);
        return adminNodeMapper.selectByExample(example);
    }

    public AdminUserNode findAdminUserNodeByUserId(Integer userId) {
        if (null == userId) {
            return null;
        }
        var example = new Example(AdminUserNode.class);
        example.createCriteria().andEqualTo(AdminUserNode.USER_ID, userId);
        return adminUserNodeMapper.selectOneByExample(example);
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
