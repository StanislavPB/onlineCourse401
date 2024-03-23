package org.onlinecourse401.project.frontEnd.ui;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.StudentDto;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestResult;
import org.onlinecourse401.project.backEnd.repositories.TestResultRepositoryInterface;
import org.onlinecourse401.project.backEnd.service.allServices.CourseService;
import org.onlinecourse401.project.backEnd.service.allServices.StudentService;
import org.onlinecourse401.project.backEnd.service.allServices.TestResultService;
import org.onlinecourse401.project.frontEnd.util.UserInput;

import java.util.List;

public class UserInputConsole {
    UserInput ui = new UserInput();
    private final CourseService courseService;
    private final StudentService studentService;
    private final TestResultService testResultService;

    public UserInputConsole(CourseService courseService, StudentService studentService, TestResultService testResultService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.testResultService = testResultService;
    }

    public void inputRegistrationData() {

//создать try catch для обработки Exception
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
        Integer chosenCourseId = chooseCourseByStudent();
        System.out.println("Student has chosen course nr.: "+chosenCourseId);
        Integer student1Id = student1.getResponseInfo().getId(); // Extract the student ID from the response
        Student student2 = studentService.findStudentById(student1Id);
        Student student = studentService.addCourseToStudent(student2,chosenCourseId);
        System.out.println(student);
        System.out.println("Familiarize yourself with the course: ");
        studentService.printCourseDataByStudent(student2);
        System.out.println("Time to learn!");
        System.out.println("...3");
        System.out.println("...2");
        System.out.println("...1");
        System.out.println("Are you ready?");
        System.out.println("If you are not, it's not my fault :-)");
        System.out.println("Now it's time for exam :-))");
        List<Integer> studentAnswers = testResultService.createStudentAnswers(student1Id);
        Integer currGrade = testResultService.calculateCurrentGrade(student1Id,studentAnswers);
        System.out.println("you answered "+currGrade+" questions correctly");
        TestResult testResultS1 = testResultService.createTestResult(student1Id,studentAnswers,currGrade);
        System.out.println(testResultS1);
        //  System.out.println(studentService.findStudentById(student1Id));
        List<TestResult> testResultListS1 = testResultService.addToTestResults(testResultS1);
        System.out.println(testResultListS1);
        Student student1Updated = studentService.addTestResultsToStudent(student1Id,testResultListS1);
        System.out.println(student1Updated);
        System.out.println(studentService.findAllStudents());
    }

    public Integer chooseCourseByStudent() {
        System.out.println("All courses: ");
        courseService.printAllCourses();
        Integer id = ui.inputInteger("Please enter number of chosen course: ");
        return id;
    }




}
