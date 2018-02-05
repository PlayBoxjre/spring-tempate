package com.playboxjre.spring.learn.cha5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.validation.DefaultMessageCodesResolver;

/**
 * com.playboxjre.spring.learn.cha5
 * Administrator
 * 2018\1\26 0026 14:46
 * EMAIL : playboxjre@gmail.com
 */
@Configuration
@ComponentScan("com.playboxjre.spring.learn.cha5")
public class SpringValidatorLearn {
    Logger log = LoggerFactory.getLogger(SpringValidatorLearn.class);

    @Bean
    public DefaultMessageCodesResolver defaultMessageCodesResolver(){
        return new DefaultMessageCodesResolver();
    }


    @Bean
    public PersonValidator validator(){
        return new PersonValidator();
    }

    @Bean
    @Scope(scopeName ="prototype" ,proxyMode = ScopedProxyMode.INTERFACES)
    public Person person(@Value("xk")  String name,@Value("1") int age){
        Person person = new Person();
        person.setAge(10);
        person.setName("");
        return person ;
    }

}
