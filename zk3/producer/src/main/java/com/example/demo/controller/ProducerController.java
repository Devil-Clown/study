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
    public String plus(@RequestParam("a") int a, @RequestParam("b") int b){
//        return producerService.plus(a,b);
        System.out.println(1);
        return ProducerService.pathRoot;
    }
}
