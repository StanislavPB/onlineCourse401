package org.onlinecourse401.project.frontEnd.adminInput;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.CourseDto;
import org.onlinecourse401.project.backEnd.dto.QuestionDto;
import org.onlinecourse401.project.backEnd.dto.TestControlDto;
import org.onlinecourse401.project.backEnd.entity.Question;
import org.onlinecourse401.project.backEnd.entity.TestControl;
import org.onlinecourse401.project.backEnd.service.allServices.CourseService;
import org.onlinecourse401.project.backEnd.service.allServices.QuestionService;
import org.onlinecourse401.project.backEnd.service.allServices.TestControlService;

import java.util.List;

public class UploadCourseData {
    private final CourseService courseService;
    private final QuestionService questionService;
    private final TestControlService testControlService;

    public UploadCourseData(CourseService courseService, QuestionService questionService, TestControlService testControlService) {
        this.courseService = courseService;
        this.questionService = questionService;
        this.testControlService = testControlService;
    }
    public void inputCourseTestQuestionData() {

        String textQuestion1 = "1. What is the main advantage of using interfaces in Java?";
        String textOption1Q1 = "0. They allow for multiple inheritance.";
        String textOption2Q1 = "1. They allow for abstraction and multiple inheritance.";
        String textOption3Q1 = "2. They allow for abstraction and multiple inheritance.";
        Integer rightOptionIndexQ1 = 1;
        String textQuestion2 = "2. What is the purpose of the 'static' keyword in Java?";
        String textOption1Q2 = "0. To create constants.";
        String textOption2Q2 = "1. To make a method or variable belong to the class rather than an instance of the class.";
        String textOption3Q2 = "2. To make a method or variable belong to the class rather than an instance of the class.";
        Integer rightOptionIndexQ2 = 0;
        String textQuestion3 = "3. What is the difference between '== and '.equals()' in Java?";
        String textOption1Q3 = "0. '==' checks for reference equality, while '.equals()' checks for object equality.";
        String textOption2Q3 = "1. '==' checks for object equality, while '.equals()' checks for reference equality.";
        String textOption3Q3 = "2. '==' checks for object equality, while '.equals()' checks for reference equality.";
        Integer rightOptionIndexQ3 = 1;
        List<String> optionsQ1 = questionService.createOptionsList(textOption1Q1, textOption2Q1, textOption3Q1);
        QuestionDto questionDto1 = questionService.createQuestionDto(textQuestion1, optionsQ1, rightOptionIndexQ1);

        List<String> optionsQ2 = questionService.createOptionsList(textOption1Q2, textOption2Q2, textOption3Q2);
        QuestionDto questionDto2 = questionService.createQuestionDto(textQuestion2, optionsQ2, rightOptionIndexQ2);

        List<String> optionsQ3 = questionService.createOptionsList(textOption1Q3, textOption2Q3, textOption3Q3);
        QuestionDto questionDto3 = questionService.createQuestionDto(textQuestion3, optionsQ3, rightOptionIndexQ3);

        List<QuestionDto> questionDtoList = questionService.createQuestionDtoList(questionDto1, questionDto2, questionDto3);
        List<Question> questionList = questionService.createQuestionList(questionDtoList);

        System.out.println(questionList);

        String testTitle = "Final Exam";
        TestControlDto testControlDto = testControlService.creatTestControlDto(testTitle,questionDtoList);
        TestControl testControl = testControlService.createTestControl(testControlDto,questionList);
        System.out.println(testControl);

        String courseName = "1. Java Pro";
        String description = "This course covers advanced Java programming concepts.";
        String content1 = "path/to/content1/file.txt";
        String content2 = "path/to/content2/file.txt";
        List<String> contents = courseService.createContentList(content1,content2);
        CourseDto courseDto = courseService.createCourseDto(courseName,description,contents,testControlDto);
       // Course course1 = courseService.createNewCourse(courseDto,testControlList);
      //  System.out.println(course1);
        ClientResponseDto<String> course1 = courseService.addNewCourse(courseDto, testControl);
        System.out.println("Response code: "+course1.getResponseCode()+"; Info:"+ course1.getMessage()+ "; Course: "+ course1.getResponseInfo());



    }

}
