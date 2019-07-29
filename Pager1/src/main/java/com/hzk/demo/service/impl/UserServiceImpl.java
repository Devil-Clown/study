package com.hzk.demo.service.impl;

import com.hzk.demo.dao.UserMapper;
import com.hzk.demo.entity.User;
import com.hzk.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll(){
        return userMapper.findAll();
    }
    @Override
    public int insert(User user){
        return userMapper.insert(user);
    }
    @Override
    public int delete(int id){
        return userMapper.delete(id);
    }
    @Override
    public int update(User user){
        return userMapper.update(user);
    }
}
