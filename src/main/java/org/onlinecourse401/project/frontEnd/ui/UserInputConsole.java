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

    public void inputRegistrationData() {
        boolean isValidData = false;
        do {
            try {
                String name1 =  ui.inputText("Please enter your username: ");
                String email1 = ui.inputText("Please enter your email: ");
                String password1 = ui.inputText("Please enter your password: ");

                StudentDto studentDto1 = new StudentDto(name1,email1,password1);
                ClientResponseDto<Student> student1 = studentService.addNewStudent(studentDto1);
                System.out.println("Response code: "+student1.getResponseCode()+"; Info:"+ student1.getMessage()+ "; : "+ student1.getResponseInfo());

                // Если регистрация прошла успешно, устанавливаем флаг isValidData в true
                if (student1.getResponseCode() == 200) {
                    isValidData = true;
                } else {
                    // Если данные не прошли валидацию, повторно запрашиваем ввод
                    System.out.println("Registration failed. Please try again.");
                }
            } catch (Exception e) {
                // Обработка ошибки регистрации
                System.out.println("An error occurred during registration: " + e.getMessage());
            }
        } while (!isValidData);

        // После успешной регистрации запросите выбор курса
        Integer chosenCourseId = chooseCourseByStudent();
        // Дальнейшая логика обработки выбранного курса
    }

    public Integer chooseCourseByStudent() {
        System.out.println("All courses: ");
        courseService.printAllCourses();
        Integer id = ui.inputInteger("Please enter number of chosen course: ");
        return id;
    }
}
