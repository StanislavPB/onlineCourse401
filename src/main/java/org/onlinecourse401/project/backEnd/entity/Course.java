package org.onlinecourse401.project.backEnd.entity;

import java.util.List;

public class Course {
    private Integer id;
    private String courseName;
    private String description;
    private List<String> content;
    private TestControl test;

    public Course(Integer id, String courseName, String description, List<String> content, TestControl test) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.content = content;
        this.test = test;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public TestControl getTest() {
        return test;
    }

    public void setTest(TestControl test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", description='" + description + '\'' +
                ", content=" + content +
                ", test=" + test +
                '}';
    }
}



