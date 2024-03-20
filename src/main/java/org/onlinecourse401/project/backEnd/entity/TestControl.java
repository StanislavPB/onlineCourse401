package org.onlinecourse401.project.backEnd.entity;


import java.util.List;

public class TestControl {
    private Integer testControlID;
    private String title;
    private List<Question> questions;

    public TestControl(Integer testControlID, String title, List<Question> questions) {
        this.testControlID = testControlID;
        this.title = title;
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Integer getTestControlID() {
        return testControlID;
    }

    public void setTestControlID(Integer testControlID) {
        this.testControlID = testControlID;
    }

    @Override
    public String toString() {
        return "TestControl{" +
                "testControlID=" + testControlID +
                ", title='" + title + '\'' +
                ", questions=" + questions +
                '}';
    }
}

