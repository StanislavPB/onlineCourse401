package org.onlinecourse401.project.backEnd.repositories;

import org.onlinecourse401.project.backEnd.entity.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuestionRepository implements QuestionRepositoryInterface {

    private Integer questionID = 0;

    private List<Question> questions;

    public QuestionRepository() {

        this.questions = new ArrayList<>();
    }

    @Override
    public Question add(Question newQuestion) {
        newQuestion.setId(++questionID);
        questions.add(newQuestion);

        return newQuestion;
    }

    @Override
    public Optional<Question> findById(Integer id) {
        for (Question question : questions){
            if (question.getId().equals(id)){
                return Optional.of(question);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Question> findByQuestion(String questionText) {
        for (Question question : questions) {
            if (question.getText().equals(questionText))
                return Optional.of(question);
        }
        return Optional.empty();
    }

    @Override
    public List<Question> findAll() {
        return questions;
    }
}
