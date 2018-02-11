package com.playboxjre.spring.learn.mvc.repositories.jsonview;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * com.playboxjre.spring.learn.mvc.repositories.jsonview
 * Administrator
 * 2018\2\6 0006 20:29
 * EMAIL : playboxjre@gmail.com
 */

public class Person {

    public interface WithoutAgeView{};
    public interface withAgeView{};

    private String name;
    private Integer age;

    public Person(){}

    public Person(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    @JsonView(WithoutAgeView.class)
    public String getName(){
        return name;
    }

    @JsonView(withAgeView.class)
    public Integer getAge(){
        return age;
    }

}
