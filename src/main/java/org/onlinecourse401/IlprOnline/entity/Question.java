package org.onlinecourse401.IlprOnline.entity;

import java.util.List;

public class Question {
    private int id;
    private String text;
    private List<String> answerOptions;
    private int correctAnswer;

    public Question(int id, String text, List<String> answerOptions, int correctAnswer) {
        this.id = id;
        this.text = text;
        this.answerOptions = answerOptions;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
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
