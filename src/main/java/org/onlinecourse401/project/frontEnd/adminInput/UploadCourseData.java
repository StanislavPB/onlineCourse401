/*package org.onlinecourse401.project.frontEnd.adminInput;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.CourseDto;
import org.onlinecourse401.project.backEnd.dto.QuestionDto;
import org.onlinecourse401.project.backEnd.dto.TestControlDto;
import org.onlinecourse401.project.frontEnd.util.UserInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UploadCourseData {

    private final CourseService service;

    public UploadCourseData(CourseService service) {
        this.service = service;
    }

    public void inputCourseData() {

        String courseName = "Java Pro";
        String description = "This course covers advanced Java programming concepts.";
        String content1 = "path/to/content1/file.txt";
        String content2 = "path/to/content2/file.txt";
        String testTitle = "Final Exam";
        String textQuestion1 = "1. What is the main advantage of using interfaces in Java?";
        String textOption1Q1 = "0. They allow for multiple inheritance.";
        String textOption2Q1 = "1. They allow for abstraction and multiple inheritance.";
        Integer rightOptionIndexQ1 = 1;
        String textQuestion2 = "2. What is the purpose of the 'static' keyword in Java?";
        String textOption1Q2 = "0. To create constants.";
        String textOption2Q2 = "1. To make a method or variable belong to the class rather than an instance of the class.";
        Integer rightOptionIndexQ2 = 0;
        String textQuestion3 = "3. What is the difference between '== and '.equals()' in Java?";
        String textOption1Q3 = "0. '==' checks for reference equality, while '.equals()' checks for object equality.";
        String textOption2Q3 = "1. '==' checks for object equality, while '.equals()' checks for reference equality.";
        Integer rightOptionIndexQ3 = 1;

    }
}
/*
        QuestionDto questionDto1 = new QuestionDto(textQuestion1, Arrays.asList(textOption1Q1,textOption2Q1),rightOptionIndexQ1);
        QuestionDto questionDto2 = new QuestionDto(textQuestion2,Arrays.asList(textOption1Q2,textOption2Q2),rightOptionIndexQ2);
        QuestionDto questionDto3 = new QuestionDto(textQuestion3,Arrays.asList(textOption1Q3,textOption2Q3),rightOptionIndexQ3);

        List<QuestionDto> questionDtoList = new ArrayList<>(Arrays.asList(questionDto1,questionDto2,questionDto3));

        TestControlDto testControlDto = new TestControlDto(testTitle,questionDtoList);
        List<TestControlDto> testControlDtoList = new ArrayList<>();

        CourseDto courseDto = new CourseDto(courseName,description,Arrays.asList(content1,content2),testControlDtoList);

        //ClientResponseDto<Integer> addCourse1 = service.addNewCourse(courseDto);
        System.out.println(addCourse1);
    }
}
/*
  String courseName = UserInput.inputText("Please enter course name:");
        String description = UserInput.inputText("Please enter course description:");
        String content1 = UserInput.inputText("Please enter path of content:");
        String content2 = UserInput.inputText("Please enter path of content:");
        String testTitle = UserInput.inputText("Please enter title of test:");
        String textQuestion1 = UserInput.inputText("Please enter question text:");
        String textOption1Q1 = UserInput.inputText("Please enter answer option text:");
        String textOption2Q1 = UserInput.inputText("Please enter answer option text:");
        String textQuestion2 = UserInput.inputText("Please enter question text:");
        String textOption1Q2 = UserInput.inputText("Please enter answer option text:");
        String textOption2Q2 = UserInput.inputText("Please enter answer option text:");
        String textQuestion3 = UserInput.inputText("Please enter question text:");
        String textOption1Q3 = UserInput.inputText("Please enter answer option text:");
        String textOption2Q3 = UserInput.inputText("Please enter answer option text:");
 */


