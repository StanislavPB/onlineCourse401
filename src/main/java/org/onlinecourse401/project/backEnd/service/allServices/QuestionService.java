package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.dto.QuestionDto;
import org.onlinecourse401.project.backEnd.entity.Question;
import org.onlinecourse401.project.backEnd.repositories.QuestionRepositoryInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionService {
    private final QuestionRepositoryInterface questionRepository;


    public QuestionService(QuestionRepositoryInterface questionRepository) {
        this.questionRepository = questionRepository;
    }
    public List<String> createOptionsList(String option1, String option2, String option3){
        List<String> questionOptions = new ArrayList<>();
        questionOptions.add(option1);
        questionOptions.add(option2);
        questionOptions.add(option3);
        return questionOptions;
    }

    public QuestionDto createQuestionDto(String text, List<String> questionOptions, Integer correctAnswer){
        QuestionDto questionDto = new QuestionDto(text,questionOptions,correctAnswer);
        return questionDto;
    }
    public List<QuestionDto> createQuestionDtoList(QuestionDto questionDto){
        List<QuestionDto> questionDtoList = new ArrayList<>();
        questionDtoList.add(questionDto);
        return questionDtoList;
}

    public List<Question> createQuestionList(List<QuestionDto> questionDtoList){
        for (QuestionDto questionDto : questionDtoList){
            Question newQuestion =   new Question(null,questionDto.getText(),questionDto.getAnswerOptions(),questionDto.getCorrectAnswer());
            questionRepository.add(newQuestion);
        }
        return questionRepository.findAll();
    }
}
