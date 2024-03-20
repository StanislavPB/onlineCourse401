package org.onlinecourse401.IlprOnline.entity;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentID {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Course currentCourse;
    private Map<Integer, List<TestResult>> courseTestResults;

    public StudentID(int id, String firstName, String lastName, String email, String password, Course currentCourse,
                     Map<Integer, List<TestResult>> courseTestResults) {
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

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }

    public Map<Integer, List<TestResult>> getCourseTestResults() {
        return courseTestResults;
    }

    public void setCourseTestResults(Map<Integer, List<TestResult>> courseTestResults) {
        this.courseTestResults = courseTestResults;
    }
}
