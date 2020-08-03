package com.phoenix.message.config.interceptor;

import com.phoenix.message.constant.SessionConstant;
import com.phoenix.message.model.po.entity.AdminUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class NeedLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        var adminUser = (AdminUser) request.getSession().getAttribute(SessionConstant.ADMIN_USER);
        if (null == adminUser) {
            throw new RuntimeException("请先登录");
        }
        return true;
    }
}