package org.onlinecourse401.LN;

import org.junit.jupiter.api.Test;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestResult;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;
import org.onlinecourse401.project.backEnd.service.allServices.StudentService;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentServiceTest {

    //проверяет, что метод addTestResultsToStudent класса StudentService корректно обрабатывает
    // ситуацию, когда студент найден в репозитории. Для этого создается макет репозитория
    // студентов, добавляется найденный студент, а затем вызывается метод для добавления
    // результатов тестов, после чего проверяется корректность добавления результатов к студенту.
    @Test
    public void testAddTestResultsToStudent_StudentFound() {
        StudentRepositoryInterface studentRepository = mock(StudentRepositoryInterface.class);
        Student student = new Student(1, "John Doe", "john@example.com", "password");
        when(studentRepository.findById(anyInt())).thenReturn(Optional.of(student));
        List<TestResult> allTestResults = Arrays.asList(
                new TestResult(1, 1, Arrays.asList(1, 2, 3), 90),
                new TestResult(1, 2, Arrays.asList(2, 3, 1), 85),
                new TestResult(2, 1, Arrays.asList(3, 1, 2), 80)
        );

        StudentService studentService = new StudentService(studentRepository, null, null);
        studentService.addTestResultsToStudent(1, allTestResults);

        assertEquals(2, student.getCourseTestResults().size());
    }



    //проверяет поведение метода addTestResultsToStudent класса StudentService в случае,
    // когда студент не найден в репозитории. Создается макет репозитория студентов,
    // где возвращается пустой Optional, а затем вызывается метод для добавления результатов
    // тестов. Проверяет, что метод генерирует исключение типа IllegalArgumentException в этом случае
    @Test
    public void testAddTestResultsToStudent_StudentNotFound() {
        StudentRepositoryInterface studentRepository = mock(StudentRepositoryInterface.class);
        when(studentRepository.findById(anyInt())).thenReturn(Optional.empty());
        List<TestResult> allTestResults = Arrays.asList(
                new TestResult(1, 1, Arrays.asList(1, 2, 3), 90),
                new TestResult(1, 2, Arrays.asList(2, 3, 1), 85),
                new TestResult(2, 1, Arrays.asList(3, 1, 2), 80)
        );

        StudentService studentService = new StudentService(studentRepository, null, null);

        assertThrows(IllegalArgumentException.class, () -> studentService.addTestResultsToStudent(1, allTestResults));
    }

//проверяет корректность работы метода findAllStudents класса StudentService.
// Создается макет репозитория студентов, в котором предполагается, что при вызове
// метода findAll вернется список ожидаемых студентов.
// Потом этот метод вызывается в сервисе, и проверяется, что список студентов,
// возвращаемый сервисом, соответствует ожидаемому списку
    @Test
    public void testFindAllStudents() {

        StudentRepositoryInterface studentRepository = mock(StudentRepositoryInterface.class);
        List<Student> expectedStudents = Arrays.asList(
                new Student(1, "John Doe", "john@example.com", "password"),
                new Student(2, "Jane Doe", "jane@example.com", "password")
        );
        when(studentRepository.findAll()).thenReturn(expectedStudents);

        StudentService studentService = new StudentService(studentRepository, null, null);
        List<Student> actualStudents = studentService.findAllStudents();

        assertEquals(expectedStudents, actualStudents);
    }
}