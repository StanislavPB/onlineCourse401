package org.onlinecourse401.project.backEnd.dto;

import org.onlinecourse401.project.backEnd.entity.Course;
import org.onlinecourse401.project.backEnd.entity.TestResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDto {
    private String name;
    private String email;
    private String password;
    private Course course;
    private List<TestResult> courseTestResults;

    public StudentDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public StudentDto(String email, String password) {        // for checking email and password for authorization
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<TestResult> getCourseTestResults() {
        return courseTestResults;
    }

    public void setCourseTestResults(List<TestResult> courseTestResults) {
        this.courseTestResults = courseTestResults;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", course=" + course +
                ", courseTestResults=" + courseTestResults +
                '}';
    }
}
