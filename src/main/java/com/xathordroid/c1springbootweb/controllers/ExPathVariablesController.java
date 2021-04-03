package com.xathordroid.c1springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/path-variables")
public class ExPathVariablesController {

    @GetMapping("/")
    public String index() {
        return "path-variables/index";
    }
    
    @GetMapping("/string/{text}")
    public String paramString(@PathVariable String text, Model model) {
        model.addAttribute("result", "The text sent is: " + text);
        return "path-variables/example-string";
    }
    
    @GetMapping("/string/{text}/{number}")
    public String mixParams(@PathVariable String text, @PathVariable(name = "number") Integer numberVariable, Model model) {
        model.addAttribute("result", "The text sent is: '" + text + "' and the number is: '" + numberVariable + "'");
        return "path-variables/example-mix";
    }
}
