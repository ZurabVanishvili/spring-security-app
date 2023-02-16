package com.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/leaders")
    public String leadersPage(){
        return "leaders-page";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin-page";
    }
}
