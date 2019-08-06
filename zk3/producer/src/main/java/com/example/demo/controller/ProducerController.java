package com.example.demo.controller;

import com.example.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping("/plus")
    public int plus(@RequestParam(value = "a", defaultValue = "1") int a,
                       @RequestParam(value = "b", defaultValue = "1") int b){
        return producerService.plus(a,b);
    }
}
