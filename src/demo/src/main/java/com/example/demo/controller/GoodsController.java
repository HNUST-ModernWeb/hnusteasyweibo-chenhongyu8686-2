package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import com.example.demo.annotation.RequireLogin;
@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    // 注入点赞业务
    @Autowired
    private GoodsService goodsService;

    // 商品列表接口
    @GetMapping("/list")
    public Result<List<String>> list() {
        List<String> data = Arrays.asList("商品A","商品B","商品C");
        return Result.ok(data);
    }

    // 点赞接口
    @PostMapping("/like/{id}")
    public Result<Integer> like(@PathVariable Long id) {
        int count = goodsService.addLike(id);
        return Result.ok(count);
    }

}
