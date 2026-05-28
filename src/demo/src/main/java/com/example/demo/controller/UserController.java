package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    // 登录接口
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User loginUser = userMapper.login(user);
        if(loginUser == null){
            return Result.error("账号或密码错误");
        }
       // 只返回用户数据，message用默认成功提示
return Result.success(loginUser);
    }

}