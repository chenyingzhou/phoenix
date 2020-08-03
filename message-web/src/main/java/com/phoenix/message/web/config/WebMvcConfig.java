package com.phoenix.message.web.config;

import com.phoenix.message.web.config.interceptor.NeedLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    NeedLoginInterceptor needLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(needLoginInterceptor)
                .excludePathPatterns("/auth/login")
                .excludePathPatterns("/auth/logout")
                .addPathPatterns("/**");
    }
}