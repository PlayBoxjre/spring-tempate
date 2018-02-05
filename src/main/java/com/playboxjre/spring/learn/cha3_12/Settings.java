package com.playboxjre.spring.learn.cha3_12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.cha3_12
 * Administrator
 * 2018\1\25 0025 10:26
 * EMAIL : playboxjre@gmail.com
 */
public class Settings {
    Logger log = LoggerFactory.getLogger(Settings.class);

    private String name;
    private String value;

    public Settings() {
    }

    public Settings(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
