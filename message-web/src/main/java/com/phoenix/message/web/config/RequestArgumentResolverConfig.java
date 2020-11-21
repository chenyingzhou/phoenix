package com.phoenix.message.web.config;

import com.phoenix.message.web.annotation.RequestGetBodyResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class RequestArgumentResolverConfig implements WebMvcConfigurer {
    @Autowired
    private RequestGetBodyResolver requestGetBodyResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(requestGetBodyResolver);
    }

}
