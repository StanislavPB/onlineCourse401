package org.onlinecourse401.project.frontEnd.adminInput;
/*
import org.onlinecourse401.project.backEnd.dto.CourseDto;
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


        QuestionDto questionDto1 = new QuestionDto(textQuestion1, Arrays.asList(textOption1Q1,textOption2Q1),0);
        QuestionDto questionDto2 = new QuestionDto(textQuestion2,Arrays.asList(textOption1Q2,textOption2Q2),0);
        QuestionDto questionDto3 = new QuestionDto(textQuestion3,Arrays.asList(textOption1Q3,textOption2Q3),0);

        List<QuestionDto> questionDtoList = new ArrayList<>(Arrays.asList(questionDto1,questionDto2,questionDto3));

        TestControlDto testControlDto = new TestControlDto(testTitle,questionDtoList);
        List<TestControlDto> testControlDtoList = new ArrayList<>();

        CourseDto courseDto = new CourseDto(courseName,description,Arrays.asList(content1,content2),testControlDtoList);

        ClientResponse<Integer> addResult = service.addNewCourse(courseDto);
        System.out.println(addResult);
    }
}

 */
