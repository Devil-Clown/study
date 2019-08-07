package com.hzk.redis1.service;

import com.hzk.redis1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    /**
     * 针对String
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    public void f(){
        User user=new User(1, "胡泽坤", 22);
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("hzk", user);
        operations.set("hzk2", user,1, TimeUnit.SECONDS);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        boolean exists=redisTemplate.hasKey("hzk2");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }

        User u = operations.get("hzk");
        System.out.println(u.toString());
    }
}
