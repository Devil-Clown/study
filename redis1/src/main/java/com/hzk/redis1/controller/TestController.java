package com.hzk.redis1.controller;

import com.hzk.redis1.model.User;
import com.hzk.redis1.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private RedisService redisService;

    //开启缓存后，多次访问，函数仅调用一次
    @RequestMapping("/")
    @Cacheable(value="user-key")
    public User get(){
        User user=new User(1, "胡泽坤", 22);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }
}
