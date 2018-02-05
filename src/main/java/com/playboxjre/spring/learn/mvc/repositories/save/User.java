package com.playboxjre.spring.learn.mvc.repositories.save;

import com.playboxjre.spring.learn.annotations.POJO;

/**
 * com.playboxjre.spring.learn.mvc.repositories
 * Administrator
 * 2018\2\4 0004 16:41
 * EMAIL : playboxjre@gmail.com
 */
@POJO
public class User {
    private String name;
    private String age;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
