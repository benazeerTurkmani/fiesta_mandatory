package com.example.demo.controller;

import com.example.demo.*;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
                                       @RequestParam Integer learningOutcome,
                                       @RequestParam String prerequisites,
                                       @RequestParam String content,
                                       @RequestParam String learningActivities,
                                       @RequestParam String examForm
    ) {
        Courses courses = new Courses(nameInDanish, nameInEnglish,isMandatory, ects,semester,classCode,  language,  minimumNumberOfStudents,  maximumNumberOfStudents,  expectedNumberOfStudents,  prerequisites,  learningOutcome, content,  learningActivities,  examForm);

        Optional<Courses> optionalCourses = coursesRepo.findById(id);
        Courses c = optionalCourses.get();

        c.setNameInDanish(courses.getNameInDanish());
        c.setNameInEnglish(courses.getNameInEnglish());
        c.setMandatory(courses.getMandatory());
        c.setEcts(courses.getEcts());
        c.setSemester(courses.getSemester());
        c.setClassCode(courses.getClassCode());
        c.setLanguage(courses.getLanguage());
        c.setMinimumNumberOfStudents(courses.getMinimumNumberOfStudents());
        c.setMaximumNumberOfStudents(courses.getMaximumNumberOfStudents());
        c.setExpectedNumberOfStudents(courses.getExpectedNumberOfStudents());
        c.setLearningOutcome(courses.getLearningOutcome());
        c.setPrerequisites(courses.getPrerequisites());
        c.setContent(courses.getContent());
        c.setLearningActivities(courses.getLearningActivities());
        c.setExamForm(courses.getExamForm());

        coursesRepo.save(c);
        return new ResponseEntity(c, HttpStatus.OK);
    }
    @DeleteMapping("/courses/delete/{id}")
    public ResponseEntity deletCourse(@PathVariable Long id){
        Optional<Courses> optionalEquipment = coursesRepo.findById(id);
        Courses courses = optionalEquipment.get();
        coursesRepo.delete(courses);
        return new ResponseEntity(courses, HttpStatus.OK);
    }

    /*******************************************Student************************************/

    @Autowired
    private StudentRepository studentRepo;

    @PostMapping("/student/new")
    public ResponseEntity newStudent(Student student){
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
        Student student = new Student(email, firstName,lastName,password);

        Optional<Student> optionalStudent = studentRepo.findById(id);
        Student stud = optionalStudent.get();
        stud.setEmail(student.getEmail());
        stud.setFirstName(student.getFirstName());
        stud.setLastName(student.getFirstName());
        stud.setPassword(student.getPassword());

        studentRepo.save(stud);
        return new ResponseEntity(stud, HttpStatus.OK);
    }
    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        Optional<Student> optionalStudent = studentRepo.findById(id);
        Student stud = optionalStudent.get();
        studentRepo.delete(stud);
        return new ResponseEntity(stud, HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/student/deleteNew/{id}")
    public ResponseEntity deleteStudent(){
        return new ResponseEntity(null, HttpStatus.FORBIDDEN);
    }


    /************************************Teacher*******************************************/

    @Autowired
    private TeacherRepository teacherRepo;

    @PostMapping("/teacher/new")
    public ResponseEntity<Teacher> newTeacher(Teacher teacher){
        Teacher teach = teacherRepo.save(teacher);
        return new ResponseEntity(teach, HttpStatus.OK);
    }

    @PutMapping("/teacher/edit/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id,
                                        @RequestParam String email,
                                        @RequestParam String firstName,
                                        @RequestParam String lastName,
                                        @RequestParam String password
    ) {

        Teacher teacher = new Teacher(email, firstName,lastName,password);

        Optional<Teacher> optionalTeacher = teacherRepo.findById(id);
        Teacher teach = optionalTeacher.get();
        teach.setEmail(teacher.getEmail());
        teach.setFirstName(teacher.getFirstName());
        teach.setLastName(teacher.getFirstName());
        teach.setPassword(teacher.getPassword());

        teacherRepo.save(teach);
        return new ResponseEntity(teach, HttpStatus.OK);
    }




    @DeleteMapping("/teacher/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Long id){
        Optional<Teacher> optionalTeacher = teacherRepo.findById(id);
        Teacher teacher = optionalTeacher.get();
        teacherRepo.delete(teacher);
        return new ResponseEntity(teacher, HttpStatus.OK);
    }

    /****************************************Administrator*******************************************/

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private BrugerRepository brugerRepository;


    @PostMapping("/administrator/new")
    public ResponseEntity<Administrator> newAdministrator(Administrator administrator){
        Administrator admin = adminRepo.save(administrator);
        return new ResponseEntity(admin, HttpStatus.OK);
    }

    @PutMapping("/administrator/edit/{id}")
    public ResponseEntity updateAdministrator(@PathVariable Long id,
                                              @RequestParam String email,
                                              @RequestParam String firstName,
                                              @RequestParam String lastName,
                                              @RequestParam String password
    ) {
        Administrator administrator = new Administrator(email, firstName,lastName,password);

        Optional<Administrator> optionalAdministrator = adminRepo.findById(id);
        Administrator admin = optionalAdministrator.get();
        admin.setEmail(administrator.getEmail());
        admin.setFirstName(administrator.getFirstName());
        admin.setLastName(administrator.getFirstName());
        admin.setPassword(administrator.getPassword());

        adminRepo.save(admin);
        return new ResponseEntity(admin, HttpStatus.OK);

    }

    @DeleteMapping("/administrator/delete/{id}")
    public ResponseEntity deleteAdministrator(@PathVariable Long id){
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
    public ResponseEntity updateStudyProgramme(@PathVariable Long id,
                                               @RequestParam String name
    ) {
        StudyProgramme studyProgramme = new StudyProgramme(name);

        Optional<StudyProgramme> optionalStudyProgramme = studyProgrammeRepository.findById(id);
        StudyProgramme studyPro = optionalStudyProgramme.get();
        studyPro.setName(studyProgramme.getName());

        studyProgrammeRepository.save(studyProgramme);
        return new ResponseEntity(studyProgramme, HttpStatus.OK);
    }
    @DeleteMapping("/studyProgramme/delete/{id}")
    public ResponseEntity deleteStudyProgramme(@PathVariable Long id){
        Optional<StudyProgramme> optionalStudyProgramme = studyProgrammeRepository.findById(id);
        StudyProgramme studyProgramme = optionalStudyProgramme.get();
        studyProgrammeRepository.delete(studyProgramme);
        return new ResponseEntity(studyProgramme, HttpStatus.OK);
    }

}
