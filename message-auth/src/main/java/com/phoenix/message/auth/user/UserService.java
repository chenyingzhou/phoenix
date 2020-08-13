package com.phoenix.message.auth.user;

import com.phoenix.message.common.entity.AuthRole;
import com.phoenix.message.common.entity.AuthUser;
import com.phoenix.message.common.beanutil.CachedBeanCopier;
import com.phoenix.message.common.service.AuthService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Resource
    AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authService.loadUserByUsername(username);
        if (null == authUser) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }

        User user = CachedBeanCopier.copy(authUser, new User());
        List<AuthRole> authRoleList = authService.findRoleListByUserId(user.getId());
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        for (AuthRole authRole : authRoleList) {
            grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_" + authRole.getId()));
        }
        user.getAuthorities().addAll(grantedAuthorityList);
        return user;
    }
}
