package com.study.hzk.common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    public static Properties load(String path){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties;
    }
}