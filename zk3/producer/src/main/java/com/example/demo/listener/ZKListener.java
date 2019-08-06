package com.example.demo.listener;

import com.example.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Component
@WebListener
public class ZKListener implements ServletContextListener {
    @Value("${producer.host}")
    public String myHost;

    @Value("${zk.host}")
    public String zkHost;
    @Value("${zk.timeout}")
    public int zkTimeout;

    @Value("${path.register}")
    public String pathRegister;
    @Value("${path.child}")
    public String pathChild;

    @Override
    //容器初始化的时候会调用
    public void  contextInitialized(ServletContextEvent sce) {
        new ProducerService().register(myHost, zkHost, zkTimeout, pathRegister, pathChild);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}

