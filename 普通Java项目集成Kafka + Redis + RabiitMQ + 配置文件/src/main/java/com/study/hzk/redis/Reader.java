package com.study.hzk.redis;

import com.study.hzk.common.util.PropertiesUtil;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class Reader {
    private JedisPool jedisPool = null;
    private static final String PREFIX = "hzk-";

    public Reader(){
        Properties properties = PropertiesUtil.load("src/main/resources/redis.properties");
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        poolConfig.setMinIdle(Integer.parseInt(properties.getProperty("minIdle")));
        poolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPool = new JedisPool( poolConfig, "localhost", 6379);
    }

    public List<String> get(){
        Jedis jedis = jedisPool.getResource();
        Set<String> keys = jedis.keys(PREFIX);
        List<String> list = new ArrayList<>();
        for(String key:keys){
            list.addAll(jedis.lrange(key,0,-1));
            list.remove(key);
        }
        return list;
    }
}
