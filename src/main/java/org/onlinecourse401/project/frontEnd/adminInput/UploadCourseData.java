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

        ////////////////////////////////////////////Course2//////////////////////////////////////////////////////////////
        String textQuestion1_2 = "1. What is the main advantage of using lists in Python?";
        String textOption1Q1_2 = "0. They allow for efficient storage of data.";
        String textOption2Q1_2 = "1. They allow for easy iteration and manipulation of data.";
        String textOption3Q1_2 = "2. They allow for automatic type conversion.";
        Integer rightOptionIndexQ1_2 = 1;
        String textQuestion2_2 = "2. What is the purpose of 'if' statement in Python?";
        String textOption1Q2_2 = "0. To define a loop.";
        String textOption2Q2_2 = "1. To make decisions based on conditions.";
        String textOption3Q2_2 = "2. To define a function.";
        Integer rightOptionIndexQ2_2 = 1;
        String textQuestion3_2 = "3. How do you define a function in Python?";
        String textOption1Q3_2 = "0. using the keyword 'method'.";
        String textOption2Q3_2 = "1. using the keyword 'function'.";
        String textOption3Q3_2 = "2. using the keyword 'define'.";
        Integer rightOptionIndexQ3_2 = 1;
        List<String> optionsQ1_2 = questionService.createOptionsList(textOption1Q1_2, textOption2Q1_2, textOption3Q1_2);
        QuestionDto questionDto1_2 = questionService.createQuestionDto(textQuestion1_2, optionsQ1_2, rightOptionIndexQ1_2);

        List<String> optionsQ2_2 = questionService.createOptionsList(textOption1Q2_2, textOption2Q2_2, textOption3Q2_2);
        QuestionDto questionDto2_2 = questionService.createQuestionDto(textQuestion2_2, optionsQ2_2, rightOptionIndexQ2_2);

        List<String> optionsQ3_2 = questionService.createOptionsList(textOption1Q3_2, textOption2Q3_2, textOption3Q3_2);
        QuestionDto questionDto3_2 = questionService.createQuestionDto(textQuestion3_2, optionsQ3_2, rightOptionIndexQ3_2);

        List<QuestionDto> questionDtoList_2 = questionService.createQuestionDtoList(questionDto1_2, questionDto2_2, questionDto3_2);
        List<Question> questionList_2 = questionService.createQuestionList(questionDtoList_2);

        System.out.println(questionList_2);

        String testTitle_2 = "Final Exam";
        TestControlDto testControlDto_2 = testControlService.creatTestControlDto(testTitle_2,questionDtoList_2);
        TestControl testControl_2 = testControlService.createTestControl(testControlDto_2,questionList_2);
        System.out.println(testControl_2);

        String courseName_2 = "2. Python Basics";
        String description_2 = "This course covers fundamental concepts of Python programming language.";
        String content1_2 = "path/to/content2.1/file.txt";
        String content2_2 = "path/to/content2.2/file.txt";
        List<String> contents_2 = courseService.createContentList(content1_2,content2_2);
        CourseDto courseDto_2 = courseService.createCourseDto(courseName_2,description_2,contents_2,testControlDto_2);
        // Course course1 = courseService.createNewCourse(courseDto,testControlList);
        //  System.out.println(course1);
        ClientResponseDto<String> course2 = courseService.addNewCourse(courseDto_2, testControl_2);
        System.out.println("Response code: "+course2.getResponseCode()+"; Info:"+ course2.getMessage()+ "; Course: "+ course2.getResponseInfo());

    }

}
