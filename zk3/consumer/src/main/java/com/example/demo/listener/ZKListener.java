package com.example.demo.listener;

import com.example.demo.utils.ZKBalance;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@Component
@WebListener
public class ZKListener implements ServletContextListener {
    @Value("${path.register}")
    private String pathRegister;
    @Value("${path.child}")
    private String pathChild;

    @Value("${zk.host}")
    private String zkHost;
    @Value("${zk.timeout}")
    private int zkTimeout;

    private ZooKeeper zooKeeper;


    private void updateServerList() {
        List<String> list = new ArrayList<>();
        try {
            List<String> children = zooKeeper.getChildren(pathRegister,true);
            for(String subNode : children) {
                byte[] data = zooKeeper.getData(pathRegister + "/" + subNode, false, null);
                String host  = new String(data,"utf-8");
                list.add(host);
            }
            //将获取的服务端口和IP保存List中
            ZKBalance.SERVICE_LIST = list;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void  contextInitialized(ServletContextEvent sce) {
        System.out.println(this.pathRegister);
        try {
            //连接zk,获得列表信息
            //watcher机制：监控获取到的服务列表的变化
            zooKeeper = new ZooKeeper(zkHost, zkTimeout, (watchedEvent) -> {
                if (watchedEvent.getType() == Watcher.Event.EventType.NodeChildrenChanged
                        && watchedEvent.getPath().equals(pathRegister)) {
                    System.out.println("***注册到zk的服务信息发生变化***");
                    updateServerList();
                }
            });
            //第一次连接的时候要返回的列表
            updateServerList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}

