package com.example.demo.controller;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZK {
    @RequestMapping("/zkGet")
    public String get(){
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("接收事件：" + watchedEvent);
            }
        };

        String value = null;
        try{
            final ZooKeeper zooKeeper = new ZooKeeper("10.150.27.241:2181",
                    5000,watcher);
            byte[] data = zooKeeper.getData("/hzk",watcher,null);
            value = new String(data);
            zooKeeper.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return "Get value from zk,value:" + value;
    }
}
