package com.example.demo.controller;

import com.example.demo.CoursesRepository;
import com.example.demo.AdminRepository;
import com.example.demo.StudentRepository;
import com.example.demo.StudyProgrammeRepository;
import com.example.demo.TeacherRepository;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class APIController {

    /*******************************************Courses*******************************************/

    @Autowired
    private CoursesRepository coursesRepo;

    @PostMapping("/courses/new")
    public ResponseEntity<Courses> newCourse(Courses courses){
        Courses course = coursesRepo.save(courses);
        return new ResponseEntity(course, HttpStatus.OK);
    }


    @PutMapping("/courses/update/{id}")
    public ResponseEntity<Courses> updateCourse(@PathVariable Long id,
                                                   @RequestParam String nameInDanish,
                                                   @RequestParam String nameInEnglish,
                                                   @RequestParam Boolean isMandatory,
                                                   @RequestParam Integer ects,
                                                   @RequestParam Integer semester,
                                                   @RequestParam String classCode,
                                                   @RequestParam String language,
                                                   @RequestParam Integer minimumNumberOfStudents,
                                                   @RequestParam Integer maximumNumberOfStudents,
                                                   @RequestParam Integer expectedNumberOfStudents,
                                                   @RequestParam String prerequisites,
                                                   @RequestParam String content,
                                                   @RequestParam String learningActivities,
                                                   @RequestParam String examForm,
                                                   @RequestParam StudyProgramme studyProgramme
    ) {
        Optional<Courses> optionalCourses = coursesRepo.findById(id);
        Courses c = optionalCourses.get();

        c.setNameInDanish(nameInDanish);
        c.setNameInEnglish(nameInEnglish);
        c.setMandatory(isMandatory);
        c.setEcts(ects);
        c.setSemester(semester);
        c.setClassCode(classCode);
        c.setLanguage(language);
        c.setMinimumNumberOfStudents(minimumNumberOfStudents);
        c.setMaximumNumberOfStudents(maximumNumberOfStudents);
        c.setExpectedNumberOfStudents(expectedNumberOfStudents);
        c.setPrerequisites(prerequisites);
        c.setContent(content);
        c.setLearningActivities(learningActivities);
        c.setExamForm(examForm);
        c.setStudyProgramme(studyProgramme);

        coursesRepo.save(c);
        return new ResponseEntity(c, HttpStatus.OK);
    }
    @DeleteMapping("/courses/delete/{id}")
    public ResponseEntity<Courses> deletCourse(@PathVariable Long id){
        Optional<Courses> optionalEquipment = coursesRepo.findById(id);
        Courses courses = optionalEquipment.get();
        coursesRepo.delete(courses);
        return new ResponseEntity(courses, HttpStatus.OK);
    }

    /*******************************************Student************************************/

    @Autowired
    private StudentRepository studentRepo;

    @PostMapping("/student/new")
    public ResponseEntity<Student> newStudent(Student student){
        Student stud = studentRepo.save(student);
        return new ResponseEntity(stud, HttpStatus.OK);
    }

    @PutMapping("/student/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                @RequestParam String email,
                                                @RequestParam String firstName,
                                                @RequestParam String lastName,
                                                @RequestParam String password
    ) {

        Optional<Student> optionalStudent = studentRepo.findById(id);
        Student stud = optionalStudent.get();
        stud.setEmail(email);
        stud.setFirstName(firstName);
        stud.setLastName(lastName);
        stud.setPassword(password);

        studentRepo.save(stud);
        return new ResponseEntity(stud, HttpStatus.OK);
    }
    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        Optional<Student> optionalStudent = studentRepo.findById(id);
        Student stud = optionalStudent.get();
        studentRepo.delete(stud);
        return new ResponseEntity(stud, HttpStatus.OK);
    }


    /************************************Teacher*******************************************/

    @Autowired
    private TeacherRepository teacherRepo;

    @PostMapping("/teacher/new")
    public ResponseEntity<Teacher> newTeacher(Teacher teacher){
        Teacher teach = teacherRepo.save(teacher);
        return new ResponseEntity(teach, HttpStatus.OK);
    }

    @PutMapping("/teacher/update/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id,
                                                 @RequestParam String email,
                                                 @RequestParam String firstName,
                                                 @RequestParam String lastName,
                                                 @RequestParam String password
    ) {

        Optional<Teacher> optionalTeacher = teacherRepo.findById(id);
        Teacher teach = optionalTeacher.get();
        teach.setEmail(email);
        teach.setFirstName(firstName);
        teach.setLastName(lastName);
        teach.setPassword(password);

        teacherRepo.save(teach);
        return new ResponseEntity(teach, HttpStatus.OK);
    }

    @DeleteMapping("/teacher/delete/{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable Long id){
        Optional<Teacher> optionalTeacher = teacherRepo.findById(id);
        Teacher teacher = optionalTeacher.get();
        teacherRepo.delete(teacher);
        return new ResponseEntity(teacher, HttpStatus.OK);
    }

    /****************************************Administrator*******************************************/

    @Autowired
    private AdminRepository adminRepo;

    @PostMapping("/administrator/new")
    public ResponseEntity<Administrator> newAdministrator(Administrator administrator){
        Administrator admin = adminRepo.save(administrator);
        return new ResponseEntity(admin, HttpStatus.OK);
    }

    @PutMapping("/administrator/update/{id}")
    public ResponseEntity<Administrator> updateAdministrator(@PathVariable Long id,
                                                 @RequestParam String email,
                                                 @RequestParam String firstName,
                                                 @RequestParam String lastName,
                                                 @RequestParam String password
    ) {

        Optional<Administrator> optionalAdministrator = adminRepo.findById(id);
        Administrator admin = optionalAdministrator.get();
        admin.setEmail(email);
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        admin.setPassword(password);

        adminRepo.save(admin);
        return new ResponseEntity(admin, HttpStatus.OK);

    }

    @DeleteMapping("/administrator/delete/{id}")
    public ResponseEntity<Administrator> deleteAdministrator(@PathVariable Long id){
        Optional<Administrator> optionalAdministrator = adminRepo.findById(id);
        Administrator administrator = optionalAdministrator.get();
        adminRepo.delete(administrator);
        return new ResponseEntity(administrator, HttpStatus.OK);
    }


    /****************************************Study programme*************************************/
    @Autowired
    private StudyProgrammeRepository studyProgrammeRepository;

    @PostMapping("/studyProgramme/new")
    public ResponseEntity<StudyProgramme> newStudyProgramme(StudyProgramme StudyProgramme){
        StudyProgramme studyProgramme = studyProgrammeRepository.save(StudyProgramme);
        return new ResponseEntity(studyProgramme, HttpStatus.OK);
    }

    @PutMapping("/studyProgramme/update/{id}")
    public ResponseEntity<StudyProgramme> updateStudyProgramme(@PathVariable Long id,
                                                       @RequestParam String name
    ) {

        Optional<StudyProgramme> optionalStudyProgramme = studyProgrammeRepository.findById(id);
        StudyProgramme studyProgramme = optionalStudyProgramme.get();
        studyProgramme.setName(name);

        studyProgrammeRepository.save(studyProgramme);
        return new ResponseEntity(studyProgramme, HttpStatus.OK);
    }
    @DeleteMapping("/studyProgramme/delete/{id}")
    public ResponseEntity<StudyProgramme> deleteStudyProgramme(@PathVariable Long id){
        Optional<StudyProgramme> optionalStudyProgramme = studyProgrammeRepository.findById(id);
        StudyProgramme studyProgramme = optionalStudyProgramme.get();
        studyProgrammeRepository.delete(studyProgramme);
        return new ResponseEntity(studyProgramme, HttpStatus.OK);
    }

}
