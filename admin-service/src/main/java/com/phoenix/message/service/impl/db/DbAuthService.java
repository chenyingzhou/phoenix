package com.phoenix.message.service.impl.db;

import com.phoenix.message.model.po.entity.AdminNode;
import com.phoenix.message.model.po.entity.AdminUser;
import com.phoenix.message.model.po.entity.AdminUserNode;
import com.phoenix.message.model.vo.AuthMenu;
import com.phoenix.message.mapper.AdminNodeMapper;
import com.phoenix.message.mapper.AdminUserMapper;
import com.phoenix.message.mapper.AdminUserNodeMapper;
import com.phoenix.message.service.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DbAuthService implements AuthService {
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
