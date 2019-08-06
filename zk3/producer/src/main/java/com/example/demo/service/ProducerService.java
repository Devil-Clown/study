package com.example.demo.service;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    public void register(String myHost, String zkHost, int timeout, String path, String child){
        try {
            ZooKeeper zooKeeper = new ZooKeeper(zkHost, timeout, (watchedEvent) -> {});
            Thread.sleep(2*1000);

            System.out.println("Path:" + path);
            Stat stat = zooKeeper.exists(path, false);
            if(stat == null){
                zooKeeper.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }

            zooKeeper.create(path + child, myHost.getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println("服务注册成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public int plus(int a,int b){return a+b;}
}
