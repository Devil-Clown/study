package com.hzk.redis1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class User implements Serializable {
    private int id;
    private String name;
    private int age;
    public User(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
