package com.hzk.mydap.dict.service;

import com.hzk.mydap.dict.model.DictBean;
import com.hzk.mydap.mapper.master.DictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DictService {
    @Autowired
    private DictMapper dictMapper;

    //dmlb + "_" + ybh, dmsm
    private static Map<Object, String> dictMap = new HashMap<>();
    //dmlb, List<DictBean>
    private static Map<String, List<DictBean>> fieldMap = new HashMap<>();

    /*说明：
        类别：261014
        运编号：9000000010等（数据库为代码，dictBean为ybh）
        代码说明：zx事故逃逸车辆
     */
    @PostConstruct
    private void initFieldMap(){
        List<DictBean> dictBeanList = dictMapper.queryAll();

        for(DictBean dict:dictBeanList){
            dictMap.put(dict.getDmlb() + "_" + dict.getYbh(), dict.getDmsm());
        }

        /*
        以代码类别为key，填充其DictBean
            1. 不同dmlb，则new，然后put，
            2. 相同dmlb，直接add
         */
        String dmlb = "";
        List<DictBean> newDictBeanList = null;
        for(DictBean dict:dictBeanList) {
            if(!dmlb.equals(dict.getDmlb())){
                //不等于
                dmlb = dict.getDmlb();
                newDictBeanList = new ArrayList<>();
                fieldMap.put(dmlb, newDictBeanList);
            }
            if(newDictBeanList != null){
                newDictBeanList.add(dict);
            }
        }

        System.out.println("=============================================");
    }



    public static List<DictBean> getDictBeanListByDmlb(String dmlb){
        return fieldMap.get(dmlb);
    }
    public static String getDmsmByDmlb_ybh(String dmlb_ybh){
        return getDmsmByDmlb_ybh(dmlb_ybh, "-");
    }
    public static String getDmsmByDmlb_ybh(String dmlb_ybh, String def){
        String value = dictMap.get(dmlb_ybh);
        if(value == null){
            return def;
        }
        return value;
    }
}
