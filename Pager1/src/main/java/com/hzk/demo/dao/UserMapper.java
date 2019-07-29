package com.hzk.demo.dao;

import com.hzk.demo.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper{
    List<User> findAll();
    int insert(User user);
    int delete(int id);
    int update(User user);
}