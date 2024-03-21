package org.onlinecourse401.project.backEnd.entity;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private List<Course> courses;
    private Map<Course, List<TestResult>> courseTestResults;

    public Student(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.courses = new ArrayList<>();
        this.courseTestResults = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Map<Course, List<TestResult>> getCourseTestResults() {
        return courseTestResults;
    }

    public void setCourseTestResults(Map<Course, List<TestResult>> courseTestResults) {
        this.courseTestResults = courseTestResults;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", courses=" + courses +
                ", courseTestResults=" + courseTestResults +
                '}';
    }
}

