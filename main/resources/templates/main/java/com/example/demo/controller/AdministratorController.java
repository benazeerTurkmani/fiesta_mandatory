package com.example.demo.controller;

import com.example.demo.BrugerRepository;
import com.example.demo.AdminRepository;
import com.example.demo.model.Administrator;
import com.example.demo.model.Bruger;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AdministratorController {

    //@Autowired
    //private BrugerRepository brugerRepo;

    @Autowired
    private AdminRepository administratorRepository;



    @GetMapping("/administrator/new")
    public String createAdministratorView(Model model) {
        model.addAttribute("bruger", new Administrator());

        return ("/administrator/createAdministrator");
    }


    @GetMapping("/administrator/edit/{id}")
    public String editCourse(Model model, @PathVariable Long id) {
        Optional<Administrator> optionalBruger = administratorRepository.findById(id);
        Administrator administrator = optionalBruger.get();
        model.addAttribute("administrator", administrator );
        return "editAdministrator";
    }

    @GetMapping("/administrator/show")
    public String showAdmin(Model model) {
        ArrayList<Administrator> administrators = (ArrayList<Administrator>) administratorRepository.findAll();
        model.addAttribute("adminstrators", administrators);

        return ("/administrator/viewAdministrator");
    }



}
