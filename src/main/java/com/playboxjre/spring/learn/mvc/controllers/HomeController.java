package com.playboxjre.spring.learn.mvc.controllers;

import com.playboxjre.spring.learn.mvc.Repository;
import com.playboxjre.spring.learn.mvc.repositories.save.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Writer;

/**
 * com.playboxjre.spring.learn.mvc.controllers
 * Administrator
 * 2018\2\4 0004 14:59
 * EMAIL : playboxjre@gmail.com
 */
@Controller
@RequestMapping("${homeroot}")
public class HomeController {
    Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private Repository userRepository;

    @RequestMapping(method = RequestMethod.GET,value = {"${homeroot}","${homepage}"})
   // @GetMapping(value = {"/", "/home"})
    public String homePage() {
        return "home";
    }

    @PostMapping("/message")
    public void handleMessage(@RequestBody String body , Writer writer) throws IOException {
        writer.write(body);
        writer.flush();
    }

    @RequestMapping(method = RequestMethod.POST,value = {"${homeroot}","${homepage}"})
    //@PostMapping(value = {"/", "/home"})
    public String postDate(@RequestParam("home-name") String name,
                           @RequestParam("home-age") String age, Model model) {
        // model.addAttribute("name", name);
        //model.addAttribute("age", age);
        log.info("name {} age {}", name, age);
        String ret = null;
        ret = String.format("redirect:/home/%s", name);//pathVariable 1
        //ret = String.format("redirect:/home/%s", name);
        return ret;
    }

    /**
     * url 模板方法 1
     *
     * @see @PathVariable
     */
    //@RequestMapping(method = RequestMethod.GET,value = "${home-regex}")
    //@GetMapping("/home/{continer:[a-z-]+}{name:-[a-z]+}")
    public String showName(@PathVariable String continer,
                           @PathVariable String version,
                           @PathVariable String name, Model model) {
        model.addAttribute("continer",continer);
        model.addAttribute("version",version);
        if (name == null)
            name = "";
        User o = (User) userRepository.get(name);
        log.info("user : {}", o);
        model.addAttribute("error", o == null ? String.format("Not find User : {}", name) : "finded");
        if (o == null) {
            o = new User();
            o.setName("null");
            o.setAge("null");
        }
        model.addAttribute("user", o);
        return "show";
    }


    /**
     * url 模板方法 1
     *
     * @see @PathVariable
     */
    @RequestMapping(method = RequestMethod.GET,value = "${home-path-variable}")
   // @GetMapping("/home/{name}")
    public String showName(@PathVariable String name, Model model) {
        if (name == null)
            name = "";
        User o = (User) userRepository.get(name);
        log.info("user : {}", o);
        model.addAttribute("error", o == null ? String.format("Not find User : {}", name) : "finded");
        if (o == null) {
            o = new User();
            o.setName("null");
            o.setAge("null");
        }
        model.addAttribute("user", o);
        return "show";
    }


}
