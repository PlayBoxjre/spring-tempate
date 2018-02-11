package com.playboxjre.spring.learn.mvc.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.playboxjre.spring.learn.mvc.repositories.jsonview.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * com.playboxjre.spring.learn.mvc.controllers
 * Administrator
 * 2018\2\6 0006 18:45
 * EMAIL : playboxjre@gmail.com
 */
@RestController
@RequestMapping("/resource")
public class RestContoller {
    Logger log = LoggerFactory.getLogger(RestContoller.class);

    @InitBinder
    public void dataBinder(WebDataBinder binder){
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }


    @RequestMapping("cookie")
    public String cookie(@CookieValue("JSESSIONID") String cookie){
     return cookie;
    }


    @GetMapping("charset")
    public String requestCharset(@RequestHeader("Accept-Charset") String charset){
        return charset;
    }


    @GetMapping("person-name")
    @JsonView(Person.WithoutAgeView.class)
    public Person getPerson(){
        return new Person("孔翔",18);
    }

    @GetMapping("person-age")
    @JsonView(Person.withAgeView.class)
    public Person getPersonWithAge(){
        return new Person("孔翔埃及水电费",88);
    }



}
