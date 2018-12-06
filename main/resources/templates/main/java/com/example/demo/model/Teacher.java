package com.example.demo.model;

/**
 * teacher. This user will login with the school credentials and can do the following tasks:
 * Create a new course with all the course information (see Course info section)
 * Edit a course they created or they are teaching with other teachers.
 */

import javax.persistence.Entity;

@Entity
public class Teacher extends Bruger {
    public Teacher(String email, String firstName, String lastName, String password) {
    }

    public Teacher() {
    }
}