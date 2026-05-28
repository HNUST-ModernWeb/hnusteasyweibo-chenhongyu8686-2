package com.example.demo.service;

import com.example.demo.entity.Post;
import com.example.demo.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    // 查询全部帖子
    public List<Post> list(){
        return postMapper.selectAll();
    }

    // 新增帖子
    public void add(Post post){
        postMapper.insert(post);
    }

    // 修改帖子
    public void update(Post post){
        postMapper.updateById(post);
    }

    // 删除帖子
    public void delete(Integer id){
        postMapper.deleteById(id);
    }

}