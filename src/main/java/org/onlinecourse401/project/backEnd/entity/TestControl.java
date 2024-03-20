package org.onlinecourse401.project.backEnd.entity;

import org.onlinecourse401.backEnd.entity.Question;

import java.util.List;

public class TestControl {
    private String title;
    private List<org.onlinecourse401.backEnd.entity.Question> questions;

    public TestControl(String title, List<org.onlinecourse401.backEnd.entity.Question> questions) {
        this.title = title;
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<org.onlinecourse401.backEnd.entity.Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "TestControl{" +
                "title='" + title + '\'' +
                ", questions=" + questions +
                '}';
    }
}

