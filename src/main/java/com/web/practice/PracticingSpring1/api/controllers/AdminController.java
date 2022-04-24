package com.web.practice.PracticingSpring1.api.controllers;

import com.web.practice.PracticingSpring1.api.models.entities.Admin;
import com.web.practice.PracticingSpring1.api.models.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminRepo adminsRepo;

    @GetMapping("/admins")
    public String admins(Model model){
        List<Admin> listAdmins = (List<Admin>) adminsRepo.findAll();
        model.addAttribute("admins", listAdmins);
        return "admin/admins.html";
    }

    @GetMapping("/admins/register")
    public String registerAdmin(){
        return "admin/register.html";
    }

    @PostMapping("/admins/register")
    public String createAdmin(Admin admin){
        adminsRepo.save(admin);
        return "redirect:/admins";
    }

    @PostMapping("/admins/{id}") //PUTMAPPING
    public String getUpdateAdmin(@PathVariable Integer id, Model model){
        Admin admin = adminsRepo.findById(id).get();
        model.addAttribute("admin", admin);
        return "admin/update.html";
    }

    @PostMapping("/admins/update/{id}")
    public String updateAdmin(@PathVariable Integer id, Admin admin){
        Admin admin1 = adminsRepo.findById(id).get();
        admin1.setName(admin.getName());
        admin1.setEmail(admin.getEmail());
        admin1.setPassword(admin.getPassword());
        adminsRepo.save(admin1);
        return "redirect:/admins";
    }

    @GetMapping("/admins/delete/{id}") //DELETEMAPPING
    public String deleteAdmin(@PathVariable Integer id){
        adminsRepo.deleteById(id);
        return "redirect:/admins";
    }
}
