package com.example.demo.controller;

import com.example.demo.utils.ZKBalance;
import com.example.demo.utils.ZKRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    private ZKBalance zkBalance = new ZKRandom();

    private final static String PLUS_left = "/plus?a=";
    private final static String PLUS_right = "&b=";
    //参数格式
    @RequestMapping("/plus")
    public int plus(@RequestParam("a")int a,
                           @RequestParam("b")int b){
        //随机获取host
        String host = zkBalance.chooseServiceHost();
        System.out.println(host);
        String url = "http://" + host + PLUS_left + a + PLUS_right + b;
        Integer res= restTemplate.getForObject(url, Integer.class);
        return res.intValue();
    }
}

