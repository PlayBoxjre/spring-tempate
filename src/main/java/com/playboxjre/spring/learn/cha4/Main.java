package com.playboxjre.spring.learn.cha4;

import com.playboxjre.spring.learn.bean.CollectionsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * com.playboxjre.spring.learn.cha4
 * Administrator
 * 2018\1\26 0026 11:42
 * EMAIL : playboxjre@gmail.com
 */
public class Main {
    Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "spring/bean/appaction-collects.xml"
        );
        CollectionsBean child = context.getBean("child", CollectionsBean.class);
    }
}
