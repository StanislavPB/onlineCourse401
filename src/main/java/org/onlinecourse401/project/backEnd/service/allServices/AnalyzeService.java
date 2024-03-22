package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;

public class AnalyzeService {
    private final StudentRepositoryInterface studentRepository;


    public AnalyzeService(StudentRepositoryInterface studentRepository) {
        this.studentRepository = studentRepository;
    }
    private void bestStudentInSchool(){
       /* s1 c1
          s2 c1
          bestGrade by Course
          s3 c2
          s4 c2

        */

    }
    private void testPassRate(){
       /*
       3Q
       maxGrade = 3 = 100%
       min =1
       0 ne sdal
       student sdelal 2 => sdelal 2/3 testa


       procent prohozhdenija testa
       public class TestPassingPercentageCalculator {

    // Метод для расчета процента прохождения тестов
    public double calculatePassingPercentage(int passedStudents, int totalStudents) {
        if (totalStudents == 0) {
            return 0.0; // Если общее количество студентов равно 0, вернуть 0%
        }

        // Расчет процента прохождения
        double passingPercentage = ((double) passedStudents / totalStudents) * 100;
        return passingPercentage;
    }
    public static void main(String[] args) {
        // Пример данных: количество студентов, прошедших тест, и общее количество студентов, сдававших тест
        int passedStudents = 85;
        int totalStudents = 100;

        TestPassingPercentageCalculator calculator = new TestPassingPercentageCalculator();
        double passingPercentage = calculator.calculatePassingPercentage(passedStudents, totalStudents);
// Вывод результата
        System.out.println("Процент прохождения тестов: " + passingPercentage + "%");
    }
        */

    }

}
