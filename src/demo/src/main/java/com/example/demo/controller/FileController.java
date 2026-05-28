package com.example.demo.controller;

import com.example.demo.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @PostMapping("/upload")
    public Result upload(@RequestParam MultipartFile file){
        // 存放路径，自行修改
        String basePath = "D:/weibo/upload/";
        File folder = new File(basePath);
        if(!folder.exists()) folder.mkdirs();

        // 生成唯一文件名
        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
        try {
            file.transferTo(new File(basePath + filename));
            // 返回可访问的图片地址
            return Result.success("http://localhost:8080/"+filename);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("上传失败");
        }
    }

}