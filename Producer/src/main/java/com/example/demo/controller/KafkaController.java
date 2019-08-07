package com.example.demo.controller;

import com.example.demo.service.ConsumerService;
import com.example.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaController {
    @Autowired
    private ProducerService producerService;
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/send")
    public String send(@RequestParam("message") String message) {
        String timeStr = producerService.send(message);
        return "Message:" + message + "\nTime:" + timeStr;
    }

    @RequestMapping("/get")
    public String get(){
        List<String> msgs = consumerService.get();
        if(msgs.size()==0){
            return "no message";
        }else{
            return msgs.toString();
        }
    }
}
