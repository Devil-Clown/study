package com.study.hzk.zookeeper;

import com.study.hzk.common.util.PropertiesUtil;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ZookeeperUsage {
    private String host = "10.150.27.241:2181";
    private int sessionTimeout = 10000;
    private String path = "/hzk";//等待创建

    //String connectString, int sessionTimeout, Watcher watcher,
    //          boolean canBeReadOnly
    //          ZKClientConfig conf
    //          boolean canBeReadOnly, HostProvider aHostProvider
    //          boolean canBeReadOnly, HostProvider aHostProvider, ZKClientConfig clientConfig
    private ZooKeeper zooKeeper = null;

    public ZookeeperUsage(){
        Properties properties = PropertiesUtil.load("src/main/resources/zk.properties");
        host = properties.getProperty("host");
        sessionTimeout = Integer.parseInt(properties.getProperty("sessionTimeout"));
        path = properties.getProperty("path");

        try {
            zooKeeper = new ZooKeeper(host, sessionTimeout, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("watcher被触发");
                }
            }, false);//非只读，即可写
            System.out.println("连接成功");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ZookeeperUsage zk = new ZookeeperUsage();
        try{
            Stat stat = zk.zooKeeper.exists(zk.path, true);
            if(stat == null){
                zk.zooKeeper.create(zk.path, "hello1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                zk.zooKeeper.create(zk.path + "/child1", "hello1-child1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                zk.zooKeeper.create(zk.path + "/child2", "hello1-child2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }

            System.out.println(zk.zooKeeper.getData(zk.path, null, null));
            List<String> items = zk.zooKeeper.getChildren(zk.path, true);
            for(String s:items){
                System.out.println("子节点：" + s);
            }

            //-1:直接修改
            zk.zooKeeper.setData(zk.path, "world".getBytes(), -1);
            System.out.println(zk.zooKeeper.getData(zk.path, null, null));

            zk.zooKeeper.delete(zk.path + "/child1", -1);
            zk.zooKeeper.delete(zk.path + "/child2", -1);
            zk.zooKeeper.delete(zk.path, -1);

        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (KeeperException e){
            e.printStackTrace();
        }finally {
            try {
                zk.zooKeeper.close();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
