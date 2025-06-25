package com.kh.springbootintercepter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kh.springbootintercepter.common.interceptor.LoginInterceptor;

@Configuration
public class IntercepterConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/login");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
