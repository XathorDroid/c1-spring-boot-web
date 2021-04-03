package com.xathordroid.c1springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping({ "/", "/redirect" })
    public String home() {
        return "redirect:/app/index";
    }
    
    @GetMapping("/google")
    public String redirectGoogle() {
        return "redirect:https://www.google.com";
    }
    
    @GetMapping("/forward")
    public String forward() {
        return "forward:/app/index";
    }
}
