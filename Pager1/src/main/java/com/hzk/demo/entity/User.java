package com.hzk.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    public User(){}
    public User(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
