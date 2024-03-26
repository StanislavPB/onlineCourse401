package org.onlinecourse401.AT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;
import org.onlinecourse401.project.backEnd.service.allServices.AnalyzeService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class TestAnalyzeServiceCountStudent {

    @Mock
    private StudentRepositoryInterface studentRepository;

    private AnalyzeService analyzeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        analyzeService = new AnalyzeService(studentRepository);
    }

    @Test
    public void testCountAllStudentsInSchlool() {

        Student student1 = new Student(1, "Alexey Ivanov", "alexey@gmailcom", "alexey1234");
        Student student2 = new Student(2, "Thomas Mueller", "thomas@gmailcom", "thomas1234");
        Student student3 = new Student(3, "Oliver Huber", "oliver@gmailcom", "oliver1234");
        List<Student> students = Arrays.asList(student1, student2, student3);

        when(studentRepository.findAll()).thenReturn(students);

        analyzeService.countAllStudentsInSchlool();

        verify(studentRepository, times(1)).findAll();

    }

}