package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 1. 静态图片资源映射（文件上传访问）
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 浏览器访问路径 /images/xxx
        registry.addResourceHandler("/images/**")
                // 对应电脑本地 D:/upload/ 文件夹
                .addResourceLocations("file:D:/upload/");
    }

    // 2. 全局跨域配置（解决Vue前端调接口报错）
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowCredentials(true)
                .maxAge(3600);
    }

}