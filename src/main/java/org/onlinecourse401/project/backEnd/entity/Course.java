package org.onlinecourse401.project.backEnd.entity;




import org.onlinecourse401.backEnd.entity.TestControl;

import java.util.List;

public class Course {
    private int id;
    private String courseName;
    private String description;
    private List<String> content;
    private List<TestControl> tests;

    public Course(int id, String courseName, String description, List<String> content, List<TestControl> tests) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.content = content;
        this.tests = tests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public List<TestControl> getTests() {
        return tests;
    }

    public void setTests(List<TestControl> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", description='" + description + '\'' +
                ", content=" + content +
                ", tests=" + tests +
                '}';
    }
}



