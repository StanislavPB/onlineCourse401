package org.onlinecourse401.project.backEnd.dto;

import org.onlinecourse401.project.backEnd.entity.Question;

import java.util.List;

public class TestControlDto {

    private String title;
    private List<QuestionDto> questionDto;

    public TestControlDto(String title, List<QuestionDto> questionDto) {
        this.title = title;
        this.questionDto = questionDto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionDto> getQuestionDto() {
        return questionDto;
    }

    public void setQuestionDto(List<QuestionDto> questionDto) {
        this.questionDto = questionDto;
    }

    @Override
    public String toString() {
        return "TestControlDto{" +
                "title='" + title + '\'' +
                ", questionDto=" + questionDto +
                '}';
    }
}
