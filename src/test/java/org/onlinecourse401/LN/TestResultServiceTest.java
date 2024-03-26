package org.onlinecourse401.LN;

import org.junit.Test;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestResult;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;
import org.onlinecourse401.project.backEnd.repositories.TestResultRepositoryInterface;
import org.onlinecourse401.project.backEnd.service.allServices.TestResultService;
import org.onlinecourse401.project.backEnd.service.validation.ValidationRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class TestResultServiceTest {

    //Выполняется проверка, что при вызове testResultService.createStudentAnswers(1)
    // выбрасывается исключение IllegalArgumentException,
    // что указывает на то, что студент с указанным ID не был найден в репозитории.
    @Test
    public void testCreateStudentAnswers_StudentNotFound() {
        StudentRepositoryInterface studentRepository = mock(StudentRepositoryInterface.class);
        when(studentRepository.findById(anyInt())).thenReturn(Optional.empty());

        TestResultService testResultService = new TestResultService(studentRepository, null, null);

        assertThrows(IllegalArgumentException.class, () -> testResultService.createStudentAnswers(1));
    }

    //Этот тест проверяет, что метод calculateCurrentGrade выбрасывает IllegalArgumentException,
    // если студент не найден в репозитории.
    @Test
    public void testCalculateCurrentGrade_StudentNotFound() {
        StudentRepositoryInterface studentRepository = mock(StudentRepositoryInterface.class);
        when(studentRepository.findById(anyInt())).thenReturn(Optional.empty());

        TestResultService testResultService = new TestResultService(studentRepository, null, null);

        List<Integer> studentAnswers = Arrays.asList(1, 2, 3);

        assertThrows(IllegalArgumentException.class, () -> testResultService.calculateCurrentGrade(1, studentAnswers));
    }

    //Этот тест проверяет, что при вызове метода createTestResult с идентификатором студента,
    // который не найден в репозитории, выбрасывается исключение IllegalArgumentException.
    @Test
    public void testCreateTestResult_StudentNotFound() {
        StudentRepositoryInterface studentRepository = mock(StudentRepositoryInterface.class);
        when(studentRepository.findById(anyInt())).thenReturn(Optional.empty());

        TestResultService testResultService = new TestResultService(studentRepository, null, null);

        List<Integer> studentAnswers = Arrays.asList(1, 2, 3);

        assertThrows(IllegalArgumentException.class, () -> testResultService.createTestResult(1, studentAnswers, 0));
    }


    //Проверка, что при добавлении нового результата теста в репозиторий TestResultRepository,
    // размер списка результатов увеличивается на единицу.
    @Test
    public void testAddToTestResults() {
        TestResultRepositoryInterface testResultRepository = mock(TestResultRepositoryInterface.class);
        when(testResultRepository.findAll()).thenReturn(Arrays.asList(new TestResult(1, 1, Arrays.asList(1, 2, 3), 90), new TestResult(2, 2, Arrays.asList(2, 3, 1), 85)));

        TestResultService testResultService = new TestResultService(null, testResultRepository, null);

        TestResult testResult = new TestResult(3, 3, Arrays.asList(3, 1, 2), 80);
        List<TestResult> results = testResultService.addToTestResults(testResult);

        assertEquals(2, results.size());
    }


}