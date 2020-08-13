package com.phoenix.message.auth;

import com.phoenix.message.auth.filter.AuthenticationFilter;
import com.phoenix.message.auth.filter.LoginFilter;
import com.phoenix.message.auth.filter.LogoutFilter;
import com.phoenix.message.common.entity.AuthRole;
import com.phoenix.message.common.service.AuthService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsUtils;

import javax.annotation.Resource;
import java.util.List;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    AuthService authService;

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors(Customizer.withDefaults());
        http.addFilter(new LoginFilter(authenticationManager()))
                .addFilter(new LogoutFilter())
                .addFilter(new AuthenticationFilter(authenticationManager()));

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
        registry.requestMatchers(CorsUtils::isPreFlightRequest).permitAll();

        List<AuthRole> authRoleList = authService.findAllRole();
        for (AuthRole authRole : authRoleList) {
            if (StringUtils.isEmpty(authRole.getPath())) {
                continue;
            }
            registry.antMatchers(authRole.getPath()).hasRole(authRole.getId().toString());
        }
        registry.anyRequest().authenticated();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
