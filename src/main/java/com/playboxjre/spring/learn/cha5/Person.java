package com.playboxjre.spring.learn.cha5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.cha5
 * Administrator
 * 2018\1\26 0026 14:47
 * EMAIL : playboxjre@gmail.com
 */
public class Person {
    Logger log = LoggerFactory.getLogger(Person.class);
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
