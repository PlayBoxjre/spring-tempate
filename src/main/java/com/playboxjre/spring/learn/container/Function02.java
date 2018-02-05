package com.playboxjre.spring.learn.container;

public class Function02 {

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    private String tag ;

    @Override
    public String toString() {
        return "Function02{" +
                "tag='" + tag + '\'' +
                '}';
    }

}
