package org.onlinecourse401.IlprOnline.Proeckt.Entity;

import java.util.List;

public class TestControl {
    private String title;
    private List<Question> questions;

    public TestControl(String title, List<Question> questions) {
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

    @Override
    public String toString() {
        return "TestControl{" +
                "title='" + title + '\'' +
                ", questions=" + questions +
                '}';
    }
}

