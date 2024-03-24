package org.onlinecourse401.project.frontEnd.ui.studentMenu;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.StudentDto;
import org.onlinecourse401.project.backEnd.entity.Course;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestResult;
import org.onlinecourse401.project.backEnd.repositories.TestResultRepositoryInterface;
import org.onlinecourse401.project.backEnd.service.allServices.AnalyzeService;
import org.onlinecourse401.project.backEnd.service.allServices.CourseService;
import org.onlinecourse401.project.backEnd.service.allServices.StudentService;
import org.onlinecourse401.project.backEnd.service.allServices.TestResultService;
import org.onlinecourse401.project.frontEnd.util.UserInput;

import java.util.List;
import java.util.Scanner;

public class UserInputConsole {
    UserInput ui = new UserInput();
    private final CourseService courseService;
    private final StudentService studentService;
    private final TestResultService testResultService;
    private final AnalyzeService analyzeService;
    private final Scanner scanner;

    public UserInputConsole(CourseService courseService, StudentService studentService, TestResultService testResultService, AnalyzeService analyzeService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.testResultService = testResultService;
        this.analyzeService = analyzeService;
        this.scanner = new Scanner(System.in);
    }
    public int getInputChoice() {
        int choice;
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return choice;
    }

    public String inputText(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public void inputRegistrationData() {
        try {
//создать try catch для обработки Exception
            boolean isValidData = false;
            ClientResponseDto<Student> student1 = null; // Declare student1 outside the try block
            do {
                try {
                    System.out.println();
                    System.out.println("-----------REGISTRATION:-----------");
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
            // Course selection loop
            boolean wantToSelectNewCourse = true;
            while (wantToSelectNewCourse) {
                Integer chosenCourseId = chooseCourseByStudent();
                System.out.println("Student has chosen course nr.: " + chosenCourseId);
                Integer student1Id = student1.getResponseInfo().getId(); // Extract the student ID from the response
                Student student2 = studentService.findStudentById(student1Id);
                Student student = studentService.addCourseToStudent(student2, chosenCourseId);
                System.out.println(student);
                System.out.println();
                System.out.println("---------FAMILIARIZE YOURSELF WITH THE COURSE: ---------");
                studentService.printCourseDataByStudent(student2);
                System.out.println("Time to learn!");
                System.out.println("...3");
                System.out.println("...2");
                System.out.println("...1");
                System.out.println("Are you ready?");
                System.out.println("If you are not, it's not my fault :-)");
                System.out.println("Now it's time for exam :-))");
                System.out.println();
                List<Integer> studentAnswers = testResultService.createStudentAnswers(student1Id);
                Integer currGrade = testResultService.calculateCurrentGrade(student1Id, studentAnswers);
                System.out.println("you answered " + currGrade + " questions correctly");
                TestResult testResultS1 = testResultService.createTestResult(student1Id, studentAnswers, currGrade);
                System.out.println(testResultS1);
                //  System.out.println(studentService.findStudentById(student1Id));
                List<TestResult> testResultListS1 = testResultService.addToTestResults(testResultS1);
                System.out.println(testResultListS1);
                Student student1Updated = studentService.addTestResultsToStudent(student1Id, testResultListS1);
                System.out.println(student1Updated);
                // Print all students
                System.out.println(studentService.findAllStudents());
                System.out.println();
                // Ask if the user wants to select a new course
                String input = ui.inputText("Do you want to select a new course? (Type 'ok' to select a new course or anything else to exit): ");
                wantToSelectNewCourse = input.trim().equalsIgnoreCase("ok");
            }
        } catch (Exception e) {
            // Handle any unexpected errors
            System.out.println("An unexpected error occurred: " + e.getMessage());

        }

    }

    public Integer chooseCourseByStudent() {
        Integer id = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.println();
            System.out.println("---------ALL COURSES FOR CHOICE:---------");
            courseService.printAllCourses();

            try {
                System.out.println("------------------------------------");
                id = Integer.parseInt(ui.inputText("Please enter the number of the chosen course: "));
                validInput = true; // If parsing succeeds, set validInput to true to exit the loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                // If parsing fails, catch the exception and prompt the user to enter a valid integer
            }
        }
        return id;
    }
        public void analyze() {
        System.out.println("===================== FOR ADMIN =================");
        System.out.println("----- ANALYZE 1 -------");
        analyzeService.bestStudentsInSchool();
        System.out.println();
        System.out.println("----- ANALYZE 2 -------");
        analyzeService.countAllStudentsInSchlool();
        System.out.println();
        System.out.println("----- ANALYZE 3 -------");
        analyzeService.testPassRate();
        System.out.println("----- END ANALYZE  -------");
        System.out.println();

    }
}
