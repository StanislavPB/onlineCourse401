package org.onlinecourse401.project.frontEnd.ui;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.StudentDto;
import org.onlinecourse401.project.backEnd.entity.Student;
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
        Student student1 = studentService.addCourseToStudent(1,id);
        System.out.println("Familiarize yourself with the course: ");
        studentService.printCourseDataByStudent(student1);
        System.out.println("Time to learn!");
        System.out.println("...3");
        System.out.println("...2");
        System.out.println("...1");
        System.out.println("Are you ready?");
        System.out.println("If you are not, it's not my fault :-)");
        System.out.println("Now it's time for exam :-))");
       // testResultService.createStudentAnswers(student1); //metod dlja UserInputConsole
        List<Integer> studentAnswers = new ArrayList<>();


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
        Student student2 = studentService.addCourseToStudent(2,id);
        System.out.println("Familiarize yourself with the course: ");
        studentService.printCourseDataByStudent(student2);

    }

}
