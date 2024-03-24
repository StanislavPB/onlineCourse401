package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnalyzeService {
    private final StudentRepositoryInterface studentRepository;

    public AnalyzeService(StudentRepositoryInterface studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void bestStudentsInSchool() {
        Optional<List<Student>> bestStudents = studentRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.summingInt(student -> student.getCourseTestResults().stream()
                                .flatMap(testResult -> testResult.getCountOfRightAnswers().describeConstable().stream())
                                .mapToInt(Integer::intValue)
                                .sum()
                        )
                ))
                .entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue);

        bestStudents.ifPresent(students -> {
            System.out.println("Best student(s) in school:");
            students.stream()
                    .sorted(Comparator.comparing(Student::getId))
                    .forEach(student -> System.out.println("StudentId - " + student.getId() + ", Max score: " +
                            student.getCourseTestResults().stream()
                                    .flatMap(testResult -> testResult.getCountOfRightAnswers().describeConstable().stream())
                                    .mapToInt(Integer::intValue)
                                    .sum()));
        });
    }

    public void countAllStudentsInSchlool() {
        // skolko studentov v shkole
    }
    public void testPassRate(){
      //  Course1: number of Students na kurse i skolko iz nih proshli test uspeshno, (a esli sdali vse, vyvesti max Ocenku)
      //  Course2: number of Students na kurse i skolko iz nih proshli test uspeshno, (a esli sdali vse, vyvesti max Ocenku)


       }




}
