package com.example.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    // 成功静态方法
    public static Result success(Object data){
        return new Result(200,"操作成功",data);
    }
    public static Result success(){
        return success(null);
    }

    // 失败静态方法
    public static Result error(String msg){
        return new Result(500,msg,null);
    }
}