package org.onlinecourse401.project;

import org.onlinecourse401.project.backEnd.repositories.*;
import org.onlinecourse401.project.backEnd.service.allServices.CourseService;
import org.onlinecourse401.project.backEnd.service.allServices.QuestionService;
import org.onlinecourse401.project.backEnd.service.allServices.StudentService;
import org.onlinecourse401.project.backEnd.service.allServices.TestControlService;
import org.onlinecourse401.project.backEnd.service.validation.ValidationRequest;
import org.onlinecourse401.project.frontEnd.adminInput.UploadCourseData;
import org.onlinecourse401.project.frontEnd.ui.UI;

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
        System.out.println();
        ValidationRequest validationRequest = new ValidationRequest();
        StudentRepositoryInterface studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository,validationRequest,courseRepository);
        UI ui = new UI(studentService);
        ui.inputRegistrationData();
    }
}
