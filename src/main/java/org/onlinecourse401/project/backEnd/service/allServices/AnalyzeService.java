package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;

import java.security.KeyStore;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AnalyzeService {
    private final StudentRepositoryInterface studentRepository;

    public AnalyzeService(StudentRepositoryInterface studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void bestStudentInSchool() {
        Optional<Student> bestStudent = studentRepository.findAll().stream()
                .max(Comparator.comparingInt(student -> {
                    int maxScore = student.getCourseTestResults().stream()
                            .flatMap(testResult -> testResult.getCountOfRightAnswers().describeConstable().stream())
                            .mapToInt(Integer::intValue)
                            .max()
                            .orElse(0);
                    return maxScore;
                }));

        bestStudent.ifPresent(student -> System.out.println("Best student in school: StudentId - " + student.getId() + ", Max score: " +
                student.getCourseTestResults().stream()
                        .flatMap(testResult -> testResult.getCountOfRightAnswers().describeConstable().stream())
                        .mapToInt(Integer::intValue)
                        .max()
                        .orElse(0)));
    }
    private void testPassRate(){
        // skolko studentov v shkole
      //  C1: number of Students na kurse i skolko iz nih proshli test uspeshno, (a esli sdali vse, vyvesti max Ocenku)
        //  C1: number of Students na kurse i skolko iz nih proshli test uspeshno, (a esli sdali vse, vyvesti max Ocenku)


       }




}
