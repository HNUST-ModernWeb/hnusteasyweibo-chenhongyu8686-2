package com.example.demo.interceptor;

import com.example.demo.annotation.RequireLogin;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 不是接口方法，直接放行
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 获取接口上的@RequireLogin注解
        RequireLogin needLogin = handlerMethod.getMethodAnnotation(RequireLogin.class);

        // 这个接口需要登录校验
        if (needLogin != null) {
            // 读取前端传过来的token
            String authHeader = request.getHeader("Authorization");

            // token不存在、为空 → 拦截，禁止访问
            if (authHeader == null || authHeader.trim().isEmpty()) {
                response.setStatus(401);
                return false;
            }
        }

        // 校验通过，放行
        return true;
    }
}