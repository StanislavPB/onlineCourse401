package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.dto.QuestionDto;
import org.onlinecourse401.project.backEnd.entity.Question;
import org.onlinecourse401.project.backEnd.repositories.QuestionRepositoryInterface;

import java.util.Arrays;
import java.util.List;

public class QuestionService {
    private final QuestionRepositoryInterface questionRepository;


    public QuestionService(QuestionRepositoryInterface questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(QuestionDto questionDto){
        Question question = new Question()
        return question;
    }


    public List<Question> createQuestionList(List<QuestionDto> questionDtoList){
        for (QuestionDto questionDto : questionDtoList){

            Question newQuestion =  questionRepository.add(new Question());
        }
    }
}
