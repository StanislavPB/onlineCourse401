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
                    .forEach(student -> {
                        int maxScore = student.getCourseTestResults().stream()
                                .flatMap(testResult -> testResult.getCountOfRightAnswers().describeConstable().stream())
                                .mapToInt(Integer::intValue)
                                .max()
                                .orElse(0); // Handle the case when max score is not present
                        System.out.println("StudentId - " + student.getId() + ", Max score: " + maxScore);
                    });
        });
    }

    public void countAllStudentsInSchlool() {
        long count = studentRepository.findAll().stream().count();
        System.out.println("Total number of students in school: " + count);
        // skolko studentov v shkole
    }

    public void testPassRate() {
        // Создаем карты для хранения количества пройденных тестов и максимальной оценки для каждого курса
        Map<Integer, Integer> passedTestsPerCourse = new HashMap<>();
        Map<Integer, Integer> totalStudentsPerCourse = new HashMap<>();
        Map<Integer, Integer> passedStudentsPerCourse = new HashMap<>();

        // Для каждого студента
        for (Student student : studentRepository.findAll()) {
            // Получаем список уникальных курсов, которые прошел студент
            List<Integer> uniqueCourseIds = student.getCourseTestResults().stream()
                    .map(TestResult::getCourseId)
                    .distinct()
                    .collect(Collectors.toList());

            // Анализируем результаты тестов для каждого уникального курса текущего студента
            for (Integer courseId : uniqueCourseIds) {
                int totalStudents = totalStudentsPerCourse.getOrDefault(courseId, 0);

                // Увеличиваем общее количество студентов на текущем курсе
                totalStudents++;
                totalStudentsPerCourse.put(courseId, totalStudents);

                // Проверяем, прошел ли студент хотя бы один тест на этом курсе
                boolean passedTest = student.getCourseTestResults().stream()
                        .anyMatch(tr -> tr.getCourseId() == courseId && tr.getCountOfRightAnswers() > 0);

                // Если студент успешно прошел тест на этом курсе, увеличиваем passedStudents
                if (passedTest) {
                    int passedStudents = passedStudentsPerCourse.getOrDefault(courseId, 0);
                    passedStudents++;
                    passedStudentsPerCourse.put(courseId, passedStudents);
                }
            }
        }

        // Вывод результатов анализа
        for (Integer courseId : passedStudentsPerCourse.keySet()) {
            System.out.println("Course nr.: " + courseId);
            System.out.println("Number of students on the course: " + totalStudentsPerCourse.getOrDefault(courseId, 0));
            System.out.println("Number of students passed tests: " + passedStudentsPerCourse.getOrDefault(courseId, 0));
        }
    }

}




