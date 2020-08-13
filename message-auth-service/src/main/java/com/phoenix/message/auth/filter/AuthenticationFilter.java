package com.phoenix.message.auth.filter;

import com.phoenix.message.auth.user.User;
import com.phoenix.message.common.constant.SessionConstant;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

public class AuthenticationFilter extends BasicAuthenticationFilter {

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        UsernamePasswordAuthenticationToken authentication = null;
        if (session != null) {
            User user = (User) session.getAttribute(SessionConstant.USER);
            if (user != null) {
                String username = user.getUsername();
                Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
                authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
            }
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

}
