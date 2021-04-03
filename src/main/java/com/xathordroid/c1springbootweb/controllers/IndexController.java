package com.xathordroid.c1springbootweb.controllers;

import com.xathordroid.c1springbootweb.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {
    
    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("title", "Hello Spring Framework!");
        return "index";
    }
    
    @GetMapping(value = "/profile")
    public String profile(Model model) {
        User user = new User();
        user.setFirstName("Roberto");
        user.setLastName("dos Santos");
        user.setEmail("userEmail@mail.com");
        
        model.addAttribute("title", "User ".concat(user.getFirstName()));
        model.addAttribute("user", user);

        return "profile";
    }
    
    @GetMapping(value = "/list")
    public String listUsers(Model model) {
        model.addAttribute("title", "Users List");

        return "users-list";
    }
    
    @ModelAttribute("users")
    public List<User> createUsersList() {
        List<User> users = new ArrayList<>();
        
        users.add(new User("Roberto", "Dos Santos", "user-one@email.com"));
        users.add(new User("Alfonso", "Jiménez", "user-two@email.com"));
        users.add(new User("Felipe", "Dos Santos", "user-three@email.com"));
        
        return users;
    }
}
