package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.entity.Course;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestResult;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;

import java.util.*;
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
        long count = studentRepository.findAll().stream().count();
        System.out.println("Total number of students in school: " + count);
        // skolko studentov v shkole
    }

    public void testPassRate() {
        //  Course1: number of Students na kurse i skolko iz nih proshli test uspeshno, (a esli sdali vse, vyvesti max Ocenku)
        //  Course2: number of Students na kurse i skolko iz nih proshli test uspeshno, (a esli sdali vse, vyvesti max Ocenku)

        // Создаем карты для хранения количества пройденных тестов и максимальной оценки для каждого курса
        Map<Integer, Integer> passedTestsPerCourse = new HashMap<>();
        Map<Integer, Integer> totalStudentsPerCourse = new HashMap<>();
        Map<Integer, Integer> passedStudentsPerCourse = new HashMap<>();

        // Для каждого студента
        for (Student student : studentRepository.findAll()) {
            // Получаем список результатов тестов для текущего студента
            List<TestResult> testResults = student.getCourseTestResults();

            // Анализируем результаты тестов для каждого курса текущего студента
            for (TestResult testResult : testResults) {
                int courseId = testResult.getCourseId();
                int totalStudents = totalStudentsPerCourse.getOrDefault(courseId, 0);
                int passedStudents = passedStudentsPerCourse.getOrDefault(courseId, 0);

                // Увеличиваем общее количество студентов на текущем курсе
                totalStudents++;

                // Если студент сдал тест, увеличиваем количество студентов, успешно сдавших тест
                if (testResult.getCountOfRightAnswers() > 0) {
                    passedStudents++;
                }

                // Записываем результаты анализа для текущего курса
                totalStudentsPerCourse.put(courseId, totalStudents);
                passedStudentsPerCourse.put(courseId, passedStudents);
            }
        }

        // Выводим результаты для каждого курса
        for (Map.Entry<Integer, Integer> entry : totalStudentsPerCourse.entrySet()) {
            int courseId = entry.getKey();
            int totalStudents = entry.getValue();
            int passedStudents = passedStudentsPerCourse.getOrDefault(courseId, 0);

            System.out.println("Course nr.: " + courseId);
            System.out.println("Number of students on the course: " + totalStudents);
            System.out.println("Number of students passed tests: " + passedStudents);
            System.out.println();
        }

    }
}




