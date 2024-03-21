package org.onlinecourse401.project.backEnd.dto;

import org.onlinecourse401.project.backEnd.entity.Course;
import org.onlinecourse401.project.backEnd.entity.TestResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Course currentCourse;
    private Map<Course, List<TestResult>> courseTestResults;


    public StudentDto(String firstName, String lastName, String email, String password) {          //for checking data for registration newStudent
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.currentCourse = null;
        this.courseTestResults = new HashMap<>();
    }

    public StudentDto(String email, String password) {        // for checking email and password for authorization
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public Map<Course, List<TestResult>> getCourseTestResults() {
        return courseTestResults;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }

    public void setCourseTestResults(Map<Course, List<TestResult>> courseTestResults) {
        this.courseTestResults = courseTestResults;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", currentCourse=" + currentCourse +
                ", courseTestResults=" + courseTestResults +
                '}';
    }
}
