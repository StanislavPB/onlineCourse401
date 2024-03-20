package org.onlinecourse401.project.backEnd.repositories;

import org.onlinecourse401.project.backEnd.entity.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface QuestionRepositoryInterface {

    public Question add(Question newQuestion);

    public Optional<Question> findById(Integer id);

    public Optional<Question> findByQuestion(String byQuestion);

    public List<Question> findAll();

}
