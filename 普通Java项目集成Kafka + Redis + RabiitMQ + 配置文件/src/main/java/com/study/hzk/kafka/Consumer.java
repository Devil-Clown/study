package com.study.hzk.kafka;

import com.study.hzk.common.util.PropertiesUtil;
import com.study.hzk.rabbitmq.MQUtil;
import com.study.hzk.redis.Reader;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class Consumer implements Runnable{
    private String topic;
    private KafkaConsumer<String, String> consumer;

    private Reader reader = new Reader();
    private MQUtil mq = new MQUtil();
    public Consumer(){
        consumer = createConsumer();
        consumer.subscribe(Collections.singleton(topic));
    }

    private KafkaConsumer createConsumer(){
        Properties properties = PropertiesUtil.load("src/main/resources/kafkaConsumer.properties");
        topic = properties.getProperty("topic");
        return new KafkaConsumer(properties);
    }

    @Override
    public void run(){
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500));
        List<String> list = reader.get();

        System.out.println("进入消费：" + records.count());
        for(ConsumerRecord<String, String> record : records){
            System.out.printf("offset = %d, key = %s, value = %s\n",
                    record.offset(), record.key(), record.value());
            mq.send(record.value());
        }

        for(String s:list){
            System.out.println("redis====" + s);
            //发送到rabbitmq
            mq.send(s);
        }
    }
}
