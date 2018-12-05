package com.example.demo.controller;

import com.example.demo.Password_helper.session_kontrol;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/teacher/frontpage")
    public String teacherFrontpage(){
        return ("teacher/frontpage");
    }
    @GetMapping("/administrator/frontpage")
    public String administratorFrontpage(){
        return ("administrator/frontpage");
    }
    @GetMapping("/student/frontpage")
    public String studentFrontpage(){
        return ("student/frontpage");
    }

    @GetMapping("/")
    public String homePage(){
        return ("homePage");
    }
}
