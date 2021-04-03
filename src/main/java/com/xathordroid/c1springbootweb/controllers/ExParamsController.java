package com.xathordroid.c1springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ExParamsController {
    
    @GetMapping("/")
    public String index() {
        return "params/index";
    }
    
    @GetMapping("/string")
    public String paramString(@RequestParam(name = "text", required = false, defaultValue = "default-value") String text,  Model model) {
        model.addAttribute("result", "The text sent is: " + text);
        return "params/example-string";
    }
    
    @GetMapping("/mix-params")
    public String mixParams(@RequestParam String greeting, @RequestParam Integer number,  Model model) {
        model.addAttribute("result", "The greeting is: '" + greeting + "' and the number is: '" + number + "'");
        return "params/example-mix";
    }
    
    @GetMapping("/mix-params-request")
    public String httpRequestParams(HttpServletRequest request, Model model) {
        String greeting = request.getParameter("greeting");
        Integer number = null;
        try {
             number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException ex) {
            number = 0;
        }
        
        model.addAttribute("result", "The greeting is: '" + greeting + "' and the number is: '" + number + "'");
        
        return "params/example-mix-request";
    }
}
