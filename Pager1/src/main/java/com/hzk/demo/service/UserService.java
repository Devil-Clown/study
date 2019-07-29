package com.hzk.demo.service;

import com.hzk.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    int insert(User user);
    int delete(int id);
    int update(User user);
}
