package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;

    @RequestMapping("/1")
    public String func(){
        return userService.select().toString();
    }

    @RequestMapping("/2")
    public List<Person> func2(){
        return personService.select();
    }
}
