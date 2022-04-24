package com.web.practice.PracticingSpring1.api.controllers;

import com.web.practice.PracticingSpring1.api.models.entities.Admin;
import com.web.practice.PracticingSpring1.api.models.repositories.AdminRepo;
import com.web.practice.PracticingSpring1.api.services.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @Autowired
    AdminRepo adminRepo;

    @GetMapping("/")
    public String index(){
        return "home/index.html";
    }

    @PostMapping("/login")
    public String login(Model model, Admin admin, HttpServletResponse response){
        Admin adm = this.adminRepo.validation(admin.getEmail(), admin.getPassword());
        if (adm != null){
            CookieService.setCookie(response, "userId", String.valueOf(adm.getIdAdmin()), 600);
            return "redirect:/admins";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "redirect:/";
    }
}
