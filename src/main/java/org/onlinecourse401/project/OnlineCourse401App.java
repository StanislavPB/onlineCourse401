package org.onlinecourse401.project;

import org.onlinecourse401.project.backEnd.repositories.*;
import org.onlinecourse401.project.backEnd.service.allServices.CourseService;
import org.onlinecourse401.project.backEnd.service.allServices.QuestionService;
import org.onlinecourse401.project.backEnd.service.allServices.TestControlService;
import org.onlinecourse401.project.frontEnd.adminInput.UploadCourseData;

public class OnlineCourse401App {
    public static void main(String[] args) {
        QuestionRepositoryInterface questionRepository = new QuestionRepository();
        TestControlRepositoryInterface testControlRepository = new TestControlRepository();
        CourseRepositoryInterface courseRepository = new CourseRepository();
        QuestionService questionService = new QuestionService(questionRepository);
        TestControlService testControlService = new TestControlService(testControlRepository);
        CourseService courseService = new CourseService(courseRepository);
        UploadCourseData uploadQuestionData = new UploadCourseData(courseService, questionService,testControlService);
        uploadQuestionData.inputCourseTestQuestionData();
    }
}
