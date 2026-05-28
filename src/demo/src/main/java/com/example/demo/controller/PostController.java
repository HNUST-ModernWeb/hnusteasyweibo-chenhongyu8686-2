package com.example.demo.controller;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import com.example.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    // 1. 查询全部帖子
    @GetMapping("/list")
    public Result list(){
        List<Post> list = postService.list();
        return Result.success(list);
    }

    // 2. 新增发帖
    @PostMapping("/add")
    public Result add(@RequestBody Post post){
        postService.add(post);
        return Result.success("发布成功");
    }

    // 3. 修改帖子
    @PutMapping("/update")
    public Result update(@RequestBody Post post){
        postService.update(post);
        return Result.success("修改成功");
    }

    // 4. 删除帖子
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        postService.delete(id);
        return Result.success("删除成功");
    }

}