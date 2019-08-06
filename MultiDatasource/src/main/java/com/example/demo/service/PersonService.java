package com.example.demo.service;

import com.example.demo.dao.mapper1.PersonMapper;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonMapper personMapper;

    public Person selectPerson(int id){
        return personMapper.selectPerson(id);
    }

    public List<Person> select(){
        return personMapper.select();
    }
}
