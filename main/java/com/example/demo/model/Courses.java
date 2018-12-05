package com.example.demo.model;

/**
 * Each courseName will contain the following informations. This data is provided by the teacher and the students can only view this data.
 * Name of the courseName in Danish
 * Name of the courseName in English
 * Study Programme. One or more of the following options:
 * Computer Science,Web DevelopmentSoftware development,IT-Security
 * Mandatory or Elective
 * ECTS
 * Course language
 * Minimum number of students
 * Expected number of students
 * Maximum number of students
 * Prerequisites
 * Learning outcome
 * Content
 * Learning activities
 * Exam form
 * Teachers
 */

import org.springframework.cglib.core.GeneratorStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Courses {

    @Id
    @GeneratedValue
    private Long id;
    private String nameInDanish;
    private String nameInEnglish;
    private Boolean isMandatory;
    private Integer ects;
    private Integer semester;
    private String classCode;
    private String language;
    private Integer minimumNumberOfStudents;
    private Integer maximumNumberOfStudents;
    private Integer expectedNumberOfStudents;
    private String prerequisites;
    private String learningOutcome;
    private String content;
    private String learningActivities;
    private String examForm;

    @OneToOne
    private StudyProgramme studyProgramme;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name="id")
    private List<Teacher> teachers;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name="id")
    private List<Student> students;
    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Student> waitingList;

    public Courses(String nameInDanish, String nameInEnglish, Boolean isMandatory, Integer ects, Integer semester, String classCode, String language, Integer minimumNumberOfStudents, Integer maximumNumberOfStudents, Integer expectedNumberOfStudents, String prerequisites, String learningOutcome, String content, String learningActivities, String examForm, StudyProgramme studyProgramme) {
        this.nameInDanish = nameInDanish;
        this.nameInEnglish = nameInEnglish;
        this.isMandatory = isMandatory;
        this.ects = ects;
        this.semester = semester;
        this.classCode = classCode;
        this.language = language;
        this.minimumNumberOfStudents = minimumNumberOfStudents;
        this.maximumNumberOfStudents = maximumNumberOfStudents;
        this.expectedNumberOfStudents = expectedNumberOfStudents;
        this.prerequisites = prerequisites;
        this.learningOutcome = learningOutcome;
        this.content = content;
        this.learningActivities = learningActivities;
        this.examForm = examForm;
        this.studyProgramme = studyProgramme;
    }

    public Courses(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameInDanish() {
        return nameInDanish;
    }

    public void setNameInDanish(String nameInDanish) {
        this.nameInDanish = nameInDanish;
    }

    public String getNameInEnglish() {
        return nameInEnglish;
    }

    public void setNameInEnglish(String nameInEnglish) {
        this.nameInEnglish = nameInEnglish;
    }

    public Boolean getMandatory() {
        return isMandatory;
    }

    public void setMandatory(Boolean mandatory) {
        isMandatory = mandatory;
    }

    public Integer getEcts() {
        return ects;
    }

    public void setEcts(Integer ects) {
        this.ects = ects;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getMinimumNumberOfStudents() {
        return minimumNumberOfStudents;
    }

    public void setMinimumNumberOfStudents(Integer minimumNumberOfStudents) {
        this.minimumNumberOfStudents = minimumNumberOfStudents;
    }

    public Integer getMaximumNumberOfStudents() {
        return maximumNumberOfStudents;
    }

    public void setMaximumNumberOfStudents(Integer maximumNumberOfStudents) {
        this.maximumNumberOfStudents = maximumNumberOfStudents;
    }

    public Integer getExpectedNumberOfStudents() {
        return expectedNumberOfStudents;
    }

    public void setExpectedNumberOfStudents(Integer expectedNumberOfStudents) {
        this.expectedNumberOfStudents = expectedNumberOfStudents;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getLearningOutcome() {
        return learningOutcome;
    }

    public void setLearningOutcome(String learningOutcome) {
        this.learningOutcome = learningOutcome;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLearningActivities() {
        return learningActivities;
    }

    public void setLearningActivities(String learningActivities) {
        this.learningActivities = learningActivities;
    }

    public String getExamForm() {
        return examForm;
    }

    public void setExamForm(String examForm) {
        this.examForm = examForm;
    }

    public StudyProgramme getStudyProgramme() {
        return studyProgramme;
    }

    public void setStudyProgramme(StudyProgramme studyProgramme) {
        this.studyProgramme = studyProgramme;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /** Andre hjælpe metoder**/

    public void addStudent(Student student){
        students.add(student);
    }

    public void addStudentToWaitingList(Student student){
        waitingList.add(student);
    }

    public void removeStudentFromWaitingList(Student student){
        int index = 0;

        for (int i = 0; i<waitingList.size(); i++){
            if(waitingList.get(i).getId().equals(student.getId())){
                index = i;
            }
        }
        waitingList.remove(index);
    }

    public List<Student> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(List<Student> waitingList) {
        this.waitingList = waitingList;
    }
}