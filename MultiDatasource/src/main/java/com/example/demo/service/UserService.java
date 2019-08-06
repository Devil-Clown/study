package com.example.demo.service;

import com.example.demo.dao.mapper2.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User selectUser(int id){
        return userMapper.selectUser(id);
    }

    public List<User> select(){
        return userMapper.select();
    }
}
