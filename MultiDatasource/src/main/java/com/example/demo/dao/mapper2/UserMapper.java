package com.example.demo.dao.mapper2;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    User selectUser(int id);

    @Select("select * from \"user\"")
    List<User> select();
}
