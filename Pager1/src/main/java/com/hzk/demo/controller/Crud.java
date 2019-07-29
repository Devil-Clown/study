package com.hzk.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzk.demo.entity.User;
import com.hzk.demo.service.ToJson;
import com.hzk.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Crud {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/add")
    public String indexAdd(){
        return "crud/add";
    }
    @RequestMapping("/delete")
    public String indexDelete(){
        return "crud/delete";
    }
    @RequestMapping("/select")
    //@ResponseBody
    public String indexSelect(){//Model model
//        PageHelper.startPage(1, 20);
//        PageInfo<User> pageInfo = new PageInfo<>(userService.findAll());
//        model.addAttribute("pageInfo", pageInfo);
//        System.out.println(pageInfo + "\n\n");
        return "crud/select";
    }
    @RequestMapping("/update")
    public String indexUpdate(){
        return "crud/update";
    }


    //处理函数
    @RequestMapping("/Add")
    public String add(@RequestParam("name") String name, @RequestParam("age") Integer age){
        userService.insert(new User(1, name, age));
        return "index";
    }
    @RequestMapping("/Delete")
    public String delete(@RequestParam("id") Integer id){
        userService.delete(id);
        return "index";
    }
    //第一个select：返回User数据
    @RequestMapping("/Select1")
    @ResponseBody
    public List<User> select1(@RequestParam(defaultValue = "1",name = "pagenum") int pagenum){
        PageHelper.startPage(pagenum, 20);
        return userService.findAll();
    }
    @RequestMapping("/Select2")
    @ResponseBody
    public PageInfo<User> select2(@RequestParam(defaultValue = "1") int pageNum){
        PageHelper.startPage(pageNum, 20);
        return new PageInfo<>(userService.findAll());
    }
    @RequestMapping(value = "/Select", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String select(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum, 6);
        List<User> users = userService.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(users, 6);
        return ToJson.toJson(pageInfo);
    }
//    public PageInfo<User> select(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
//        PageHelper.startPage(pageNum, 20);
//        PageInfo<User> pageInfo = new PageInfo<>(userService.findAll());
//        System.out.println(pageInfo);
//        System.out.println(pageInfo.toString() + "\n\n");
//        return pageInfo;
//    }

    @RequestMapping("/Update")
    public String update(@RequestParam("id") Integer id, @RequestParam("name") String name,
                         @RequestParam("age") Integer age){
        userService.update(new User(id,name,age));
        return "index";
    }
}
