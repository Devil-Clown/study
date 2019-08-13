package com.study.hzk.common.util;

import java.text.SimpleDateFormat;

public class TimeUtil {
    public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void sleep(int timeMills){
        try{
            Thread.sleep(timeMills);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
