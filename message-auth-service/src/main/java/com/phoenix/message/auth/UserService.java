package com.phoenix.message.auth;

import com.phoenix.message.common.model.po.entity.AdminUser;
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
        AdminUser adminUser = authService.findAdminUserByUsername(username);
        if (null == adminUser) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        User user = new User();
        user.setId(adminUser.getId());
        user.setUsername(adminUser.getName());
        user.setPassword(adminUser.getPassword());
        user.setStatus(adminUser.getStatus());
        String role = "ROLE_ADMIN";
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        user.setAuthorities(authorities);
        return user;
    }
}
