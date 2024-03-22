package org.onlinecourse401.project.frontEnd.ui;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.StudentDto;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.service.allServices.CourseService;
import org.onlinecourse401.project.backEnd.service.allServices.StudentService;
import org.onlinecourse401.project.frontEnd.util.UserInput;

public class UserInputConsole {
    UserInput ui = new UserInput();
    private final CourseService courseService;
    private final StudentService studentService;

    public UserInputConsole(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    public void inputRegistrationData() {
//создать try catch для обработки Exception

        try {
        String name1 =  ui.inputText("Please enter your username: ");
        String email1 = ui.inputText("Please enter your email: ");
        String password1 = ui.inputText("Please enter your password: ");

        StudentDto studentDto1 = new StudentDto(name1,email1,password1);
        ClientResponseDto<Student> student1 = studentService.addNewStudent(studentDto1);
        System.out.println("Response code: "+student1.getResponseCode()+"; Info:"+ student1.getMessage()+ "; : "+ student1.getResponseInfo());
        } catch (Exception e) {
            // Handle the exception here
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    public Integer chooseCourseByStudent() {

        System.out.println("All courses: ");
        courseService.printAllCourses();
        Integer id = ui.inputInteger("Please enter number of chosen course: ");
        return id;
    }
}
