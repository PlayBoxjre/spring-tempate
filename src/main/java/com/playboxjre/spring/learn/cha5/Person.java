package com.playboxjre.spring.learn.cha5;

/**
 * com.playboxjre.spring.learn.cha5
 * Administrator
 * 2018\1\26 0026 14:47
 * EMAIL : playboxjre@gmail.com
 */
public class Person {
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
