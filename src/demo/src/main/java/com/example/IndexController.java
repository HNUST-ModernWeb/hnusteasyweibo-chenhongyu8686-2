package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 关键注解，缺一不可
@RestController
public class IndexController {

    // 绑定根地址 localhost:8080
    @GetMapping("/")
    public String index() {
        return "✅ 访问成功！404问题已彻底解决";
    }

}