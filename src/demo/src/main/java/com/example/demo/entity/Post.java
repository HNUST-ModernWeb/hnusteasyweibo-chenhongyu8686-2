package com.example.demo.entity;

import lombok.Data;

@Data // 自动生成get、set、toString
public class Post {
    private Integer id;
    private String title;
    private String content;
    private String imageUrl; // 对应setImageUrl爆红的字段
}