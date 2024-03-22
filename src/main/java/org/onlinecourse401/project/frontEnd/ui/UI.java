package org.onlinecourse401.project.frontEnd.ui;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.StudentDto;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.service.allServices.StudentService;

public class UI {
    private final StudentService studentService;

    public UI(StudentService studentService) {
        this.studentService = studentService;
    }
    public void inputRegistrationData() {
//создать try catch для обработки Exception
        String email1 = "ekaB@gmail.com";
        String password1 = "TestK1234!";
        String name1 = "User1";

        String email2 = "ektB@gmail.com";
        String password2 = "testK1234!";
        String name2 = "User2";

        StudentDto studentDto1 = new StudentDto(name1,email1,password1);
        StudentDto studentDto2 = new StudentDto(name2,email2,password2);
        ClientResponseDto<Student> student1 = studentService.addNewStudent(studentDto1);
        ClientResponseDto<Student> student2 = studentService.addNewStudent(studentDto2);
        System.out.println("Response code: "+student1.getResponseCode()+"; Info:"+ student1.getMessage()+ "; : "+ student1.getResponseInfo());
        System.out.println("Response code: "+student2.getResponseCode()+"; Info:"+ student2.getMessage()+ "; : "+ student2.getResponseInfo());




    }
}
