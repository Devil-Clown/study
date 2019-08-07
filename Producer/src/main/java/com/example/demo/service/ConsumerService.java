package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerService {
    private List<String> msgs = new ArrayList<>();

//    @KafkaListener(topics = {"hzk"})
//    public void listen(ConsumerRecord<?, ?> record) {
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            msgs.add(record + "  " + message);
//
//        }
//    }

    @KafkaListener(topics = {"hzk"})
    public void listen(String message) {
        msgs.add(message);
    }

    public List<String> get(){return msgs;}
}
