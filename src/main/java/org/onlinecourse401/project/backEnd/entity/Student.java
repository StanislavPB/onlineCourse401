package org.onlinecourse401.project.backEnd.entity;


import org.onlinecourse401.backEnd.entity.Course;
import org.onlinecourse401.backEnd.entity.TestResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private org.onlinecourse401.backEnd.entity.Course currentCourse;
    private Map<org.onlinecourse401.backEnd.entity.Course, List<TestResult>> courseTestResults;

    public Student(int id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.currentCourse = null;
        this.courseTestResults = new HashMap<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public org.onlinecourse401.backEnd.entity.Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(org.onlinecourse401.backEnd.entity.Course currentCourse) {
        this.currentCourse = currentCourse;
    }

    public Map<org.onlinecourse401.backEnd.entity.Course, List<TestResult>> getCourseTestResults() {
        return courseTestResults;
    }

    public void setCourseTestResults(Map<Course, List<TestResult>> courseTestResults) {
        this.courseTestResults = courseTestResults;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", currentCourse=" + currentCourse +
                ", courseTestResults=" + courseTestResults +
                '}';
    }
}

