package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    // 模拟数据库，存储全局点赞总数
    private int likeNum = 0;

    // 点赞+1业务方法
    public int addLike(Long id){
        // 后续这里可以替换成 数据库SQL更新点赞数
        likeNum++;
        // 返回最新点赞数量
        return likeNum;
    }

}
