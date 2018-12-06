package com.example.demo.controller;

import com.example.demo.CoursesRepository;
import com.example.demo.Password_helper.session_kontrol;
import com.example.demo.StudentRepository;
import com.example.demo.StudyProgrammeRepository;
import com.example.demo.model.Courses;
import com.example.demo.model.Student;
import com.example.demo.model.StudyProgramme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class StudyProgrammeController {

    @Autowired
    private StudyProgrammeRepository studyProgrammeRepository;

    @GetMapping("/studyProgramme/new")
    public String createStudyProgramme(Model model) {

        model.addAttribute("studyprogramme", new StudyProgramme());

        return ("/administrator/createStudyProgramme");
    }

    @GetMapping("/studyProgramme/edit/{id}")
    public String studyProgrammeEdit(Model model, @PathVariable Long id) {
        Optional<StudyProgramme> optionalStudyProgramme = studyProgrammeRepository.findById(id);
        StudyProgramme studyProgramme = optionalStudyProgramme.get();
        model.addAttribute("studyProgramme", studyProgramme);
        return "/administrator/editStudyprogramme";
    }

    @GetMapping("/studyProgramme/show")
    public String showStudyProgramme(Model model) {
        ArrayList<StudyProgramme> studyProgrammes = (ArrayList<StudyProgramme>) studyProgrammeRepository.findAll();
        model.addAttribute("studyprogramme", studyProgrammes);

        return ("/administrator/viewStudyProgramme");
    }


    /******************************************Waiting list**************************************/

    @Autowired
    private CoursesRepository coursesRepository;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/administrator/waitinglist")
    public String waitingListView(Model model, HttpServletRequest request){
        ArrayList<Courses> courses = (ArrayList<Courses>) coursesRepository.findAll();
        model.addAttribute("courses", courses);

        return ("/administrator/waitingList");
    }

    /*@GetMapping("/administrator/waitinglist/course/{id}")
    public String waitingListCourseView(@PathVariable Long id, Model model, HttpServletRequest request){

        Optional<Courses> optionalCourse = coursesRepository.findById(id);
        Courses courses = optionalCourse.get();

        model.addAttribute("courses", courses);

        return ("/administrator/waitingList_student");
    }

    @GetMapping("/administrator/waitinglist/course/{courseId}/approve/{studentId}")
    public String approve(@PathVariable Long courseId, @PathVariable Long studentId, HttpServletRequest request){
            Optional<Courses> optionalCourse = coursesRepository.findById(courseId);
            Courses courses = optionalCourse.get();

            Student student = studentRepository.findById(studentId).get();

            courses.addStudent(student);
            courses.removeStudentFromWaitingList(student);

            coursesRepository.save(courses);

        return "/administrator/waitinglist/course/" + courseId;
    }*/
}