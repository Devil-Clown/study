package com.example.demo.dao.mapper1;

import com.example.demo.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PersonMapper {
    Person selectPerson(int id);

    @Select("select * from \"person\"")
    List<Person> select();
}
