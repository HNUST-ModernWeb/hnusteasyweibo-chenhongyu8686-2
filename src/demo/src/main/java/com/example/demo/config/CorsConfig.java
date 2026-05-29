package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 允许本地所有前端端口（适配你Vue的8081）
                .allowedOriginPatterns("http://localhost:*")
                // 允许全部请求方式
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // 允许全部请求头
                .allowedHeaders("*")
                // 允许携带Token/cookie
                .allowCredentials(true)
                // 预检请求缓存1小时
                .maxAge(3600);
    }
}