package org.onlinecourse401.TesterLN;

import org.junit.jupiter.api.Test;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;
import org.onlinecourse401.project.backEnd.service.allServices.AnalyzeService;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;


public class AnalyzeServiceTest {

    @Test
    public void testPassRate() {
        // Создаем макет репозитория студентов
        StudentRepositoryInterface studentRepository = mock(StudentRepositoryInterface.class);

        // Создаем экземпляр сервиса анализа
        AnalyzeService analyzeService = new AnalyzeService(studentRepository);

        // Создаем тестовые данные для студентов и их результатов тестов
        // Здесь нужно добавить фактические данные, чтобы протестировать метод
        // Например:
        // Создаем студентов и добавляем результаты их тестов

        // Вызываем метод, который мы хотим протестировать
        analyzeService.testPassRate();

        // Проверяем, что метод вызывает необходимые методы и не выбрасывает исключения
        // Например, можно проверить, что метод findAll() вызывается у репозитория студентов
        verify(studentRepository, times(1)).findAll();
    }


        @Test
        public void testPrintResults() {
            // Создаем макет сервиса анализа
            AnalyzeService analyzeService = mock(AnalyzeService.class);

            // Подготавливаем данные для передачи в метод вывода результатов анализа
            Map<Integer, Integer> passedStudentsPerCourse = new HashMap<>();
            passedStudentsPerCourse.put(1, 5);
            passedStudentsPerCourse.put(2, 7);

            Map<Integer, Integer> totalStudentsPerCourse = new HashMap<>();
            totalStudentsPerCourse.put(1, 10);
            totalStudentsPerCourse.put(2, 12);

        }

    }
