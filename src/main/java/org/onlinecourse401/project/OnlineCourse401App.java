package org.onlinecourse401.project;

import org.onlinecourse401.project.backEnd.repositories.*;
import org.onlinecourse401.project.backEnd.service.allServices.*;
import org.onlinecourse401.project.backEnd.service.validation.ValidationRequest;
import org.onlinecourse401.project.frontEnd.adminInput.UploadCourseData;
import org.onlinecourse401.project.frontEnd.ui.UIHistory;
import org.onlinecourse401.project.frontEnd.ui.UserInputConsole;

public class OnlineCourse401App {
    public static void main(String[] args) {
        QuestionRepositoryInterface questionRepository = new QuestionRepository();
        TestControlRepositoryInterface testControlRepository = new TestControlRepository();
        CourseRepositoryInterface courseRepository = new CourseRepository();
        QuestionService questionService = new QuestionService(questionRepository);
        TestControlService testControlService = new TestControlService(testControlRepository);
        CourseService courseService = new CourseService(courseRepository);
        TestResultRepositoryInterface testResultRepository = new TestResultRepository();
        TestResultService testResultService = new TestResultService(testResultRepository);
        UploadCourseData uploadQuestionData = new UploadCourseData(courseService, questionService,testControlService);
        uploadQuestionData.inputCourseTestQuestionData();
        System.out.println();
        ValidationRequest validationRequest = new ValidationRequest();
        StudentRepositoryInterface studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository,validationRequest,courseRepository);

        //History:
        UIHistory uiHistory = new UIHistory(courseService,studentService,testResultService);
        System.out.println("========== Student 1 ==============");
        uiHistory.inputRegistrationDataStudent1();
        uiHistory.chooseCourseByStudent1();
        System.out.println("========== Student 2 ==============");
        uiHistory.inputRegistrationDataStudent2();
        uiHistory.chooseCourseByStudent2();

        System.out.println("========================USER INPUT CONSOLE========================================================0");

        //Work from console:
        UserInputConsole uiConsole = new UserInputConsole(courseService,studentService);
        uiConsole.inputRegistrationData();

    }
}
