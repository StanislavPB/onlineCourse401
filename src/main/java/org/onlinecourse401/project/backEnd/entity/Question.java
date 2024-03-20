package org.onlinecourse401.project.backEnd.entity;

import java.util.List;

public class Question {
    private Integer id;
    private String text;
    private List<String> answerOptions;
    private Integer correctAnswer;

    public Question(Integer id, String text, List<String> answerOptions, Integer correctAnswer) {
        this.id = id;
        this.text = text;
        this.answerOptions = answerOptions;
        this.correctAnswer = correctAnswer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<String> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", answerOptions=" + answerOptions +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
