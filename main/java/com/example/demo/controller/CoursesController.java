package com.example.demo.controller;

import com.example.demo.*;
import com.example.demo.Password_helper.session_kontrol;
import com.example.demo.model.Courses;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CoursesController {

    @Autowired
    private CoursesRepository coursesRepo;

    /*  @Autowired
      private StudyProgrammeRepository studyRepo;
      @Autowired
      private BrugerRepository brugerRepo;
      @Autowired
      private TeacherRepository teacherRepo;
      @Autowired
      private StudentRepository studentRepo;

      private Long editId;
  */
    @GetMapping("/courses/show")
    public String showCourses(Model model) {
        ArrayList<Courses> courses = (ArrayList<Courses>) coursesRepo.findAll();
        model.addAttribute("courses", courses);

        return ("/teacher/showCourses");
    }

    @GetMapping("/courses/new")
    public String createCourses(Model model) {
        model.addAttribute("courses", new Courses());
        return "/administrator/createCourses";
    }

    @GetMapping("/courses/edit/{id}")
    public String editCourses(Model model, @PathVariable Long id) {
        Optional<Courses> optionalEquipment = coursesRepo.findById(id);
        Courses courses = optionalEquipment.get();
        model.addAttribute("equipment", courses);
        return "/administrator/editCourses";
    }

    /*@GetMapping("/administrator/createCourses")
    public String createCourse(Model model, HttpServletRequest request, Courses c) {
        model.addAttribute("teacher", teacherRepo.findAll());
        model.addAttribute("studyprogramme", studyRepo.findAll());
        model.addAttribute("courses", new Courses());
        return session_kontrol.redirectTeacher(request, "createCourses");
    }*/


    /*@GetMapping("/courses/edit/{id}")
    public String editCourse(Model model, @PathVariable Long id) {
        Optional<Courses> courseOptional = coursesRepo.findById(id);
        Courses courses = courseOptional.get();
        editId = courses.getId();
        model.addAttribute("courses", courses);
        model.addAttribute("teacher", teacherRepo.findAll());
        model.addAttribute("studyprogramme", studyRepo.findAll());
        return ("administrator/editCourses");
    }


    /***/

    /*@GetMapping("/course/join/{id}")
    public ModelAndView joinCourse(@PathVariable Long id, HttpServletRequest request) {
            Optional<Courses> optionalCourse = coursesRepo.findById(id);
            Courses courses = optionalCourse.get();

            courses.addStudentToWaitingList(student);
            coursesRepo.save(courses);


            return "teacher/showCourses";

    }*/

    @GetMapping("/courses/coursesInfo")
    public String showMore(@RequestParam Long id, Model model, Courses courses, HttpServletRequest request) {
        Optional<Courses> optionalCourse = coursesRepo.findById(id);
        Courses course = optionalCourse.get();
        model.addAttribute("courses", course);
        model.addAttribute("brugerType", request.getSession().getAttribute("bruger").getClass().getSimpleName());
        return "teacher/coursesInfo";
    }
}

    /*@GetMapping("/courses/students/{id}")
    public String courseStudents(@PathVariable Long id, Model model, HttpServletRequest request) {
        Optional<Courses> optionalCourse = coursesRepo.findById(id);
        Courses courses = optionalCourse.get();
        model.addAttribute("student", studentRepo.findAll());
        model.addAttribute("courses", courses);
        return ("student/studentAssignCourses");
    }*/
