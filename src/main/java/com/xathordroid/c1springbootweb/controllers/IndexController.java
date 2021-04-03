package com.xathordroid.c1springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {
    
    @GetMapping(value ="/index")
    public String index(Model model) {
        model.addAttribute("title", "Hello Spring Framework!");
        return "index";
    }
}
