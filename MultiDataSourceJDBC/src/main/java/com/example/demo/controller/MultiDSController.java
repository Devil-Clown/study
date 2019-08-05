package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.model.User;
import com.example.demo.service.PersonService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MultiDSController {
    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;

    @RequestMapping("/1")
    @ResponseBody
    public List<Person> query1(){
        return personService.select();
    }

    @RequestMapping("/2")
    @ResponseBody
    public List<User> query2(){
        return userService.select();
    }
}
