package com.study.hzk.redis;

import com.study.hzk.common.util.PropertiesUtil;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class Writer implements Runnable {
    private static final String PREFIX = "hzk-";

    private JedisPool jedisPool = null;
    public Writer(){
        createJedisPool();
    }

    private void createJedisPool(){
        Properties properties = PropertiesUtil.load("src/main/resources/redis.properties");

        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        poolConfig.setMinIdle(Integer.parseInt(properties.getProperty("minIdle")));
        poolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPool = new JedisPool( poolConfig, "localhost", 6379);
//        Jedis jedis1 = jedisPool.getResource();
//        System.out.println(jedis1.get(key));
    }

    private void createJedisPoolWithCluster(){
        Properties properties = PropertiesUtil.load("src/main/resources/redis.properties");

        GenericObjectPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        poolConfig.setMinIdle(Integer.parseInt(properties.getProperty("minIdle")));
        poolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));

        Set<HostAndPort> jedisClusterNode = new HashSet<>();
        jedisClusterNode.add(new HostAndPort("...", 7001));
        jedisClusterNode.add(new HostAndPort("...", 7002));
        //..添加节点

        JedisCluster jc = new JedisCluster(jedisClusterNode, poolConfig);
        //直接使用jc操作redis
        jc.set("key", "value");
        System.out.println(jc.get("key"));
    }

    //单机单连接
    public static void test(){
        Jedis jedis = new Jedis("localhost", 6379);
        String key = "hzk" + System.currentTimeMillis();
        jedis.set(key, "helloworld 1");
        System.out.println(jedis.get(key));
    }

    @Override
    public void run(){
        Jedis jedis = jedisPool.getResource();
        String key = PREFIX + System.currentTimeMillis();
        for(int i=0;i<10;++i) {
            jedis.lpush(key, "value " + i);
            System.out.println("Writer====value:" + "value " + i);
        }
        jedis.close();
    }
}
