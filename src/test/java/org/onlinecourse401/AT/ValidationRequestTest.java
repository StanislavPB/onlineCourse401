package org.onlinecourse401.AT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.onlinecourse401.project.backEnd.dto.StudentDto;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;
import org.onlinecourse401.project.backEnd.service.allServices.AnalyzeService;
import org.onlinecourse401.project.backEnd.service.validation.ValidationRequest;
import org.onlinecourse401.project.frontEnd.util.UserInput;

import java.util.Arrays;
import java.util.List;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationRequestTest {

    ValidationRequest validationRequest;
    StudentDto studentDto;


    @BeforeEach
    void setUp() {
        validationRequest = new ValidationRequest();

    }

    @Test
    void testPassword() {
        StudentDto studentDto1 = new StudentDto("Oliver Mueller", "e@t.m", "1255ert");
        assertTrue(validationRequest.checkPassword(studentDto1));
    }

    @Test
    void testEmail() {
        StudentDto studentDto2 = new StudentDto("Huber herbert", "huber.herbe@rtgmail.com", "fghglkj");
        assertTrue(validationRequest.checkEmail(studentDto2));
    }
}

