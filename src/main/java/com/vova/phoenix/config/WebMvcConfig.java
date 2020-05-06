package com.vova.phoenix.config;

import com.vova.phoenix.config.interceptor.NeedLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    NeedLoginInterceptor needLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(needLoginInterceptor)
                .excludePathPatterns("/auth/login")
                .excludePathPatterns("/auth/logout")
                .addPathPatterns("/**");
    }
}