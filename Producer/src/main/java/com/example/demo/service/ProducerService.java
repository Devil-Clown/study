package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ProducerService {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${topic}")
    private String topic;

    public String send(String message){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = simpleDateFormat.format(new Date());
        String sendMsg = "Message:" + message + "  "  + timeStr;
        kafkaTemplate.send(topic, sendMsg);
//        ListenableFuture future = kafkaTemplate.send(topic, sendMsg);
//        future.addCallback(o -> System.out.println("添加消息成功:" + sendMsg),
//                throwable -> System.out.println("添加消息失败:" + sendMsg));
        return timeStr;
    }
}
