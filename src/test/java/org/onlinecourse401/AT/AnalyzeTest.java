package org.onlinecourse401.AT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestResult;
import org.onlinecourse401.project.backEnd.repositories.StudentRepository;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;
import org.onlinecourse401.project.backEnd.service.allServices.AnalyzeService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnalyzeTest {

    AnalyzeService analyzeService;
    StudentRepositoryInterface studentRepositoryInterface;
    StudentRepository studentRepository;


    @BeforeEach
    public void setUp() {
        analyzeService = new AnalyzeService(studentRepository);
    }

        @Test
        void testBestStudentsInSchool () {


            TestResult testResult1 = new TestResult(1,1, Collections.singletonList(2),3);
            TestResult testResult2 = new TestResult(2,2, Collections.singletonList(1),1);
            TestResult testResult3 = new TestResult(3,3, Collections.singletonList(3),2);
            List<TestResult> testResults = Arrays.asList(testResult1,testResult2,testResult3);

            Student student1 = new Student(1, "Alex", "alex@gmail.com", "dfdfdf", null,testResults);
            Student student2 = new Student(2, "Alex", "alex@gmail.com", "dfdfdf", null,testResults);
            Student student3 = new Student(3, "Alex", "alex@gmail.com", "dfdfdf", null,testResults);

            StudentRepository studentRepository = new StudentRepository();
            studentRepository.add(student1);
            studentRepository.add(student2);
            studentRepository.add(student3);

            AnalyzeService analyzeService = new AnalyzeService(studentRepository);

            String output = TestUtils.captureSystemOutput(analyzeService::bestStudentsInSchool);

            assertTrue(output.contains("Best student(s) in school:"));
            assertTrue(output.contains("StudentId  1, Max score: 1"));
            assertTrue(output.contains("StudentId  2, Max score: 2"));
            assertTrue(output.contains("StudentId  3, Max score: 2"));

        }
    }

