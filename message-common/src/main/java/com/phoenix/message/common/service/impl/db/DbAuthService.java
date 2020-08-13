package com.phoenix.message.common.service.impl.db;

import com.phoenix.message.common.entity.AuthRole;
import com.phoenix.message.common.entity.AuthUser;
import com.phoenix.message.common.entity.AuthUserRole;
import com.phoenix.message.common.mapper.auth.AuthRoleMapper;
import com.phoenix.message.common.mapper.auth.AuthUserMapper;
import com.phoenix.message.common.mapper.auth.AuthUserRoleMapper;
import com.phoenix.message.common.service.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
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
}
