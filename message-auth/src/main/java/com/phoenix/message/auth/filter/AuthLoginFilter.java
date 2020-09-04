package com.phoenix.message.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phoenix.message.auth.user.User;
import com.phoenix.message.common.constant.SessionConstant;
import com.phoenix.message.common.util.JacksonUtil;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class AuthLoginFilter extends AbstractAuthenticationProcessingFilter {

    private final AuthenticationManager authenticationManager;

    public AuthLoginFilter(AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher("/auth/login", "POST"));
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            User user = new ObjectMapper().readValue(req.getInputStream(), User.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException {
        User user = (User) auth.getPrincipal();
        HttpSession session = req.getSession();
        session.setAttribute(SessionConstant.USER, user);
        res.setHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf-8");
        res.getWriter().write(new Response(0, "登录成功", null).toString());
    }

    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf-8");
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.getWriter().write(new Response(response.getStatus(), "用户名或密码错误", null).toString());
    }

    @Getter
    private static class Response {
        private final Integer code;
        private final String msg;
        private final Object data;

        private Response(Integer code, String msg, Object data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        public String toString() {
            return JacksonUtil.toJson(this);
        }
    }
}
