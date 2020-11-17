package com.petstore.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/welcome")
    public @ResponseBody String welcomeMessage(){
        return "Welcome to our pet store";
    }

    @GetMapping("/render")
    public String displayWelcomePage(){
        return "welcome";
    }
}
