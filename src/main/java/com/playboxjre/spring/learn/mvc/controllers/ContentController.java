package com.playboxjre.spring.learn.mvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * com.playboxjre.spring.learn.mvc.controllers
 * Administrator
 * 2018\2\10 0010 17:13
 * EMAIL : playboxjre@gmail.com
 */

@Controller
@RequestMapping("/content")
public class ContentController {
    Logger log = LoggerFactory.getLogger(ContentController.class);

    @GetMapping
    public String getContent(Model model){
        model.addAttribute("hello","hello");
        model.addAttribute("world","world");
        return "myView";
    }

}
