package com.hzk.redis2.controller;

import com.hzk.redis2.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @Autowired
    private RedisService redisService;

    @RequestMapping("/")
    public String getProperties(){
        redisService.set("3213", 1213,900l);
        return redisService.get("3213").toString();
    }

}
