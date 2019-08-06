package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Value("producer.host")
    public static String producerHost;
    @Value("producer.port")
    public static int producerPort;

    @Value("zk.host")
    public static String zkHost;
    @Value("zk.port")
    public static int zkPort;
    @Value("zk.timeout")
    public static int zkTimeout;

    @Value("path.root")
    public static String pathRoot;
    @Value("path.service")
    public static String pathService;
    @Value("path.child")
    public static String pathChild;

    public ProducerService(){
//        try {
//            ZooKeeper zooKeeper = new ZooKeeper(Config.ZK.host + ":" + Config.ZK.port,
//                    Config.ZK.timeout, (watchedEvent) -> {
//            });
//            Thread.sleep(2*1000);
//
//            String path = Config.Path.root + Config.Path.service;
//            Stat stat = zooKeeper.exists(path, false);
//            if(stat == null){
//                zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//            }
//
//            zooKeeper.create(path + Config.Path.child, (Config.Producer.host + ":" + Config.Producer.port).getBytes(),
//                    ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
//            System.out.println("服务注册成功");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    public int plus(int a,int b){return a+b;}
}
