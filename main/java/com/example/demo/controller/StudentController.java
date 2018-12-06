package com.example.demo.controller;

import com.example.demo.BrugerRepository;
import com.example.demo.Password_helper.session_kontrol;
import com.example.demo.StudentRepository;
import com.example.demo.model.Administrator;
import com.example.demo.model.Bruger;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //@Autowired
    //private BrugerRepository brugerRepository;

    @GetMapping("/student/new")
    public String createStudent(Model model) {

        model.addAttribute("bruger", new Student());

        return ("/administrator/createStudent");
    }

    @GetMapping("/student/edit/")
    public String studentEdit(Model model, @PathVariable Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student = optionalStudent.get();
        model.addAttribute("student", student);
        return "/administrator/editStudent";
    }

    @GetMapping("/student/show")
    public String showStudent(Model model) {
        ArrayList<Student> students = (ArrayList<Student>) studentRepository.findAll();
        model.addAttribute("students", students);

        return ("/administrator/viewStudent");
    }
}
