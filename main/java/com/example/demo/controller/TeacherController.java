package com.example.demo.controller;

import com.example.demo.TeacherRepository;
import com.example.demo.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/teacher/new")
    public String createTeacher(Model model, HttpServletRequest request) {

        model.addAttribute("bruger", new Teacher());

        return ("/administrator/createTeacher");
    }

    @GetMapping("/teacher/edit/{id}")
    public String teacherEdit(Model model, @PathVariable Long id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        Teacher teacher = optionalTeacher.get();
        model.addAttribute("teacher", teacher);
        return "/administrator/editTeacher";
    }

    @GetMapping("/teacher/show")
    public String showAdmin(@PathVariable Long id, Model model) {
        ArrayList<Teacher> teachers = (ArrayList<Teacher>) teacherRepository.findAll();
        model.addAttribute("teacher", teachers);

        return ("administrator/viewTeacher");
    }


}