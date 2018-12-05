package com.example.demo.model;

/**Administration worker. This user will login with the school credentials and can do the following tasks:
 * See a list of the students that signed up for a specific course. This list will be sorted according to the timestamp of the signed up moment.
 * Approve or reject a signed up request from the student.
 */

import javax.persistence.Entity;

@Entity
public class Administrator extends Bruger {

}