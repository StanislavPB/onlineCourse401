package org.onlinecourse401.project;

import org.onlinecourse401.project.backEnd.repositories.QuestionRepository;
import org.onlinecourse401.project.backEnd.repositories.QuestionRepositoryInterface;
import org.onlinecourse401.project.backEnd.service.allServices.QuestionService;
import org.onlinecourse401.project.frontEnd.adminInput.UploadQuestionData;

public class OnlineCourse401App {
    public static void main(String[] args) {
        QuestionRepositoryInterface questionRepository = new QuestionRepository();
        QuestionService questionService = new QuestionService(questionRepository);
        UploadQuestionData uploadQuestionData = new UploadQuestionData(questionService);
        uploadQuestionData.inputQuestionData();
    }
}
