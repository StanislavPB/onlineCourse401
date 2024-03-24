package org.onlinecourse401.project.frontEnd.ui.studentMenu;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.StudentDto;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.service.allServices.StudentService;
import org.onlinecourse401.project.frontEnd.util.UserInput;

public class StudentRegistrationMenu implements StudentMenuCommand {
    UserInput ui = new UserInput();
    private final StudentService studentService;

    public StudentRegistrationMenu(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void executeCommand() {
        boolean isValidData = false;
        ClientResponseDto<Student> student1 = null; // Declare student1 outside the try block
        do {
            try {
                String name1 = ui.inputText("Please enter your username: ");
                String email1 = ui.inputText("Please enter your email: ");
                String password1 = ui.inputText("Please enter your password: ");

                StudentDto studentDto1 = new StudentDto(name1, email1, password1);
                student1 = studentService.addNewStudent(studentDto1); // Initialize student1
                System.out.println("Response code: " + student1.getResponseCode() + "; Info:" + student1.getMessage() + "; : " + student1.getResponseInfo());

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

    }

    @Override
    public String getMenuName() {
        return "Account is created";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
