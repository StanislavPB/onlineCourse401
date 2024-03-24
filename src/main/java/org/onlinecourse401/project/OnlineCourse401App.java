package org.onlinecourse401.project;

import org.onlinecourse401.project.backEnd.repositories.*;
import org.onlinecourse401.project.backEnd.service.allServices.*;
import org.onlinecourse401.project.backEnd.service.validation.ValidationRequest;
import org.onlinecourse401.project.frontEnd.adminInput.UploadCourseData;
import org.onlinecourse401.project.frontEnd.ui.UIHistory;
import org.onlinecourse401.project.frontEnd.ui.UserInputConsole;
import org.onlinecourse401.project.frontEnd.ui.studentMenu.StudentUserMenu;

import java.util.Scanner;

public class OnlineCourse401App {
    public static void main(String[] args) {
        QuestionRepositoryInterface questionRepository = new QuestionRepository();
        TestControlRepositoryInterface testControlRepository = new TestControlRepository();
        CourseRepositoryInterface courseRepository = new CourseRepository();
        QuestionService questionService = new QuestionService(questionRepository);
        TestControlService testControlService = new TestControlService(testControlRepository);
        CourseService courseService = new CourseService(courseRepository);
        TestResultRepositoryInterface testResultRepository = new TestResultRepository();
        ValidationRequest validationRequest = new ValidationRequest();
        StudentRepositoryInterface studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository,validationRequest,courseRepository);
        TestResultService testResultService = new TestResultService(studentRepository,testResultRepository,validationRequest);
        UploadCourseData uploadQuestionData = new UploadCourseData(courseService, questionService,testControlService);
        AnalyzeService analyzeService = new AnalyzeService(studentRepository);
        uploadQuestionData.inputCourseTestQuestionData();
        System.out.println();

        //History:
        UIHistory uiHistory = new UIHistory(courseService,studentService,testResultService);
        System.out.println("========== Student 1 ==============");
        uiHistory.inputRegistrationDataStudent1();
        uiHistory.chooseCourseByStudent1();
        System.out.println("========== Student 2 ==============");
        uiHistory.inputRegistrationDataStudent2();
        uiHistory.chooseCourseByStudent2();

        /*System.out.println("========================USER INPUT CONSOLE========================================================0");

        //Work from console:
        UserInputConsole uiConsole = new UserInputConsole(courseService,studentService,testResultService,analyzeService);
        uiConsole.inputRegistrationData();


         */


        System.out.println("========================StudentUserMenu========================================================0");
        UserInputConsole uiConsole = new UserInputConsole(courseService,studentService,testResultService,analyzeService);
        StudentUserMenu studentUserMenu = new StudentUserMenu(uiConsole);
        studentUserMenu.displayMenu();

    }
}
