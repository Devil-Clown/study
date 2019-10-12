package com.hzk.mydap;

import com.hzk.mydap.dict.model.DictBean;
import com.hzk.mydap.dict.service.DictService;
import com.hzk.mydap.mapper.ds2.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
//@ServletComponentScan
@Controller
public class MydapApplication {

    public static void main(String[] args) {
        SpringApplication.run(MydapApplication.class, args);
    }

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        long res = studentMapper.queryAll();
        System.out.println(res);

        String res2 = DictService.getDmsmByDmlb_ybh("261014_9000000010");

        return "hello," + res2 + "," + res;
    }
}
