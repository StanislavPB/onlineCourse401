package org.onlinecourse401.project.frontEnd.ui;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.StudentDto;
import org.onlinecourse401.project.backEnd.service.allServices.StudentService;

public class UI {
    private final StudentService studentService;

    public UI(StudentService studentService) {
        this.studentService = studentService;
    }
    public void inputRegistrationData() {

        String email1 = "ekateB@gmail.com";
        String password1 = "TestK1234!";

        String email2 = null;
        String password2 = null;

        StudentDto studentDto1 = new StudentDto(email1,password1);
        StudentDto studentDto2 = new StudentDto(email2,password2);
        ClientResponseDto<String> student1 = studentService.addNewStudent(studentDto1);
        ClientResponseDto<String> student2 = studentService.addNewStudent(studentDto2);
        System.out.println("Response code: "+student1.getResponseCode()+"; Info:"+ student1.getMessage()+ "; : "+ student1.getResponseInfo());
        System.out.println("Response code: "+student2.getResponseCode()+"; Info:"+ student2.getMessage()+ "; : "+ student2.getResponseInfo());




    }
}
