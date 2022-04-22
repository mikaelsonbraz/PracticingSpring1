package com.web.practice.PracticingSpring1.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String index(Model model){
        model.addAttribute("name", "Mikaelson");
        return "home/index.html";
    }
}
