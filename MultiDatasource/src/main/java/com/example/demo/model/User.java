package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class User implements Serializable {
    private int id;
    private String name;
    private int age;

    public User(){}
    public User(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "User: " + id + ", " + name + ", " + age;
    }
}
