package com.playboxjre.spring.learn.mvc.controllers;

import com.playboxjre.spring.learn.mvc.Repository;
import com.playboxjre.spring.learn.mvc.repositories.save.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    @RequestMapping(method = RequestMethod.POST,value = {"${homeroot}","${homepage}"})
    public String homeform(@RequestParam("home-name") String homeName,
                           @RequestParam("home-age") String homeAge, Model model, RedirectAttributes attributes){
        User user = new User();
        user.setName(homeName);
        user.setAge(homeAge);
        model.addAttribute("user",user);
        attributes.addFlashAttribute("user",user);

        return "redirect:/show/"+homeName;
    }




    @PostMapping("/message")
    public void handleMessage(@RequestBody String body , Writer writer) throws IOException {
        writer.write(body);
        writer.flush();
    }


    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "<html>hello my name is kong <hr/></html>";
    }




    /**
     * url 模板方法 1
     *
     * @see @PathVariable
     */
    //@RequestMapping(method = RequestMethod.GET,value = "${home-regex}")
    //@GetMapping("/home/{continer:[a-z-]+}{name:-[a-z]+}")


    /**
     * url 模板方法 1
     *
     * @see @PathVariable
     */
    @RequestMapping(method = RequestMethod.GET,value = "/show/{name}")
   // @GetMapping("/show/{name}")
    public String showName(@PathVariable String name, Model model) {
        if (name == null)
            name = "";
        User o = (User) userRepository.get(name);
        log.info("user : {}", o);
        model.addAttribute("error", o == null ? String.format("Not find User : {%s}", name) : "finded");
        if (o == null) {
            o = new User();
            o.setName("null");
            o.setAge("null");
        }
        model.addAttribute("user", o);
        return "show";
    }






}
