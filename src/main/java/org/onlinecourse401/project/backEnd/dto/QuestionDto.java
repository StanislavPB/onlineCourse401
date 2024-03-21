package org.onlinecourse401.project.backEnd.dto;

import java.util.ArrayList;
import java.util.List;

public class QuestionDto {
    private String text;
    private List<String> answerOptions;
    private Integer correctAnswer;

    public QuestionDto(String text, List<String> answerOptions, Integer correctAnswer) {
        this.text = text;
        this.answerOptions = answerOptions;
        this.correctAnswer = correctAnswer;
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
        return "QuestionDto{" +
                "text='" + text + '\'' +
                ", answerOptions=" + answerOptions +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
