package com.example.demo.mapper;

import com.example.demo.entity.Post;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PostMapper {

    @Select("select * from post")
    List<Post> selectAll();

    @Insert("insert into post(content,create_time,user_id) values(#{content},now(),#{userId})")
    void insert(Post post);

    @Update("update post set content=#{content} where id=#{id}")
    void updateById(Post post);

    @Delete("delete from post where id=#{id}")
    void deleteById(Integer id);

}