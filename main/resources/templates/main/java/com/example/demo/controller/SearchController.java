package com.example.demo.controller;

/*import com.example.demo.CoursesRepository;
import com.example.demo.Password_helper.Search;
import com.example.demo.Password_helper.session_kontrol;
import com.example.demo.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class SearchController {
    @Autowired
    private CoursesRepository coursesRepo;

    @PostMapping("/search")
    public ModelAndView search(@RequestParam String search, HttpServletRequest request) {

        ArrayList<Courses> courses = (ArrayList<Courses>) coursesRepo.findAll(Specification
                .where(Search.doesFieldContain(search, "nameInDanish"))
                .or(Search.doesFieldContain(search, "nameInEnglish"))
        );

        ModelAndView mav = new ModelAndView(session_kontrol.redirectStudent(request, "searchResult"));
        mav.getModel().put("courses", courses);

        return mav;
    }

    @GetMapping("/student/searchCoursesStudent")
    public String SearchCoursesStudent(Model model, HttpServletRequest request) {
        model.addAttribute("courses", new Courses());
        return session_kontrol.redirectStudent(request, "SearchCoursesStudent");
    }

    @PostMapping("/student/searchCoursesStudent")
    public ModelAndView SearchCoursesStudent(@ModelAttribute Courses courses, HttpServletRequest request) {

        ArrayList<Courses> course = (ArrayList<Courses>) coursesRepo.findAll(Specification
                .where(Search.doesFieldContain(courses.getNameInDanish(), "nameInDanish"))
                .and(Search.doesFieldContain(courses.getNameInEnglish(), "nameInEnglish"))
                .and(Search.doesFieldContain(courses.getExamForm(), "examForm"))
                .and(Search.doesFieldContain(courses.getLanguage(), "language"))
                .and(Search.doesFieldContain(courses.getClassCode(), "classCode"))
                .and(Search.doesForeignKeyContain(courses.getStudyProgramme().getName(), "name", "studyProgramme"))
        );

        ModelAndView mav = new ModelAndView(session_kontrol.redirectStudent(request,"searchResult"));
        mav.getModel().put("course", course);

        HttpSession session = request.getSession();
        session.setAttribute("lastView", mav);

        return mav;
    }
}
*/