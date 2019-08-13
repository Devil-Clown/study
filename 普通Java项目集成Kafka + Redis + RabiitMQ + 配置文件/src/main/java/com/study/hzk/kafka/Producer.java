package com.study.hzk.kafka;

import com.study.hzk.common.util.PropertiesUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer implements Runnable {
    private String topic;
    private KafkaProducer<String, String> producer;
    private static int id = 1;//消息内容一部分

    public Producer(){
        producer = createProducer();
    }

    private KafkaProducer createProducer(){
        Properties properties = PropertiesUtil.load("src/main/resources/kafkaProducer.properties");
        topic = properties.getProperty("topic");
        //kafka producer 默认命名，自动赋值到producer
        return new KafkaProducer(properties);
    }

    @Override
    public void run(){
        String value = "hello world" + id;
        String key = "key " + id++;
        ProducerRecord<String,String> record = new ProducerRecord<>(topic, key, value);
        producer.send(record);
        System.out.printf("Send ==== key:%s, value:%s\n", record.key(), record.value());
    }
}
