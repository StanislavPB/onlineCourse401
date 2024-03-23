package org.onlinecourse401.project.frontEnd.ui;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.StudentDto;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestResult;
import org.onlinecourse401.project.backEnd.service.allServices.CourseService;
import org.onlinecourse401.project.backEnd.service.allServices.StudentService;
import org.onlinecourse401.project.backEnd.service.allServices.TestControlService;
import org.onlinecourse401.project.backEnd.service.allServices.TestResultService;
import org.onlinecourse401.project.frontEnd.util.UserInput;

import java.util.ArrayList;
import java.util.List;

public class UIHistory {
    private final CourseService courseService;
    private final StudentService studentService;
    private final TestResultService testResultService;

    public UIHistory(CourseService courseService, StudentService studentService, TestResultService testResultService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.testResultService = testResultService;

    }
    public void inputRegistrationDataStudent1() {
//создать try catch для обработки Exception
        String email1 = "ekaB@gmail.com";
        String password1 = "TestK1234!";
        String name1 = "User1";

        StudentDto studentDto1 = new StudentDto(name1,email1,password1);
        ClientResponseDto<Student> student1 = studentService.addNewStudent(studentDto1);
        System.out.println("Response code: "+student1.getResponseCode()+"; Info:"+ student1.getMessage()+ "; : "+ student1.getResponseInfo());

    }
    public void chooseCourseByStudent1() {
        System.out.println("All courses: ");
        courseService.printAllCourses();
        Integer id = 1;
        System.out.println("Student 1 has chosen course nr.: "+id);
        Integer student1Id = 1;
        Student student1 = studentService.findStudentById(student1Id);
        Student student = studentService.addCourseToStudent(student1,id);
        System.out.println(student);
        System.out.println("Familiarize yourself with the course: ");
        studentService.printCourseDataByStudent(student1);
        System.out.println("Time to learn!");
        System.out.println("...3");
        System.out.println("...2");
        System.out.println("...1");
        System.out.println("Are you ready?");
        System.out.println("If you are not, it's not my fault :-)");
        System.out.println("Now it's time for exam :-))");
        List<Integer> studentAnswers = testResultService.createStudentAnswers(student1Id); //metod dlja UserInputConsole
       /* List<Integer> studentAnswers = new ArrayList<>();
        studentAnswers.add(1);
        studentAnswers.add(1);
        studentAnswers.add(1);

        */
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
  //  public void evaluateTestByStudent1()
/////////// STUDENT2 ///////////////////////////////////////////////////////////////////////////////////////
    public void inputRegistrationDataStudent2() {
//создать try catch для обработки Exception

        String email2 = "ektB@gmail.com";
        String password2 = "testK1234!";
        String name2 = "User2";

        StudentDto studentDto2 = new StudentDto(name2,email2,password2);
        ClientResponseDto<Student> student2 = studentService.addNewStudent(studentDto2);
        System.out.println("Response code: "+student2.getResponseCode()+"; Info:"+ student2.getMessage()+ "; : "+ student2.getResponseInfo());

    }
    public void chooseCourseByStudent2() {
        System.out.println("All courses: ");
        courseService.printAllCourses();
        Integer id = 2;
        System.out.println("Student 2 has chosen course nr.: "+id);
        Integer student2Id = 2;
        Student student2 = studentService.findStudentById(student2Id);
        Student student = studentService.addCourseToStudent(student2,id);
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
        List<Integer> studentAnswers2 = testResultService.createStudentAnswers(student2Id); //metod dlja UserInputConsole
       /* List<Integer> studentAnswers = new ArrayList<>();
        studentAnswers.add(1);
        studentAnswers.add(1);
        studentAnswers.add(1);

        */
        Integer currGrade2 = testResultService.calculateCurrentGrade(student2Id,studentAnswers2);
        System.out.println("you answered "+currGrade2+" questions correctly");
        TestResult testResultS2 = testResultService.createTestResult(student2Id,studentAnswers2,currGrade2);
        System.out.println(testResultS2);
        //  System.out.println(studentService.findStudentById(student1Id));
        List<TestResult> testResultListS2 = testResultService.addToTestResults(testResultS2);
        System.out.println(testResultListS2);
        Student student2Updated = studentService.addTestResultsToStudent(student2Id,testResultListS2);
        System.out.println(student2Updated);
        System.out.println(studentService.findAllStudents());


    }

}
