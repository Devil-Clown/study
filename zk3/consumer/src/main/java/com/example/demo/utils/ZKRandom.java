package com.example.demo.utils;

import org.springframework.util.CollectionUtils;

import java.util.Random;

public class ZKRandom extends ZKBalance {
    @Override
    public String chooseServiceHost() {
        String result = "";
        if (!CollectionUtils.isEmpty(SERVICE_LIST)) {
            int nextInt = new Random().nextInt(SERVICE_LIST.size());
            result = SERVICE_LIST.get(nextInt);
        }
        return result;
    }
}

