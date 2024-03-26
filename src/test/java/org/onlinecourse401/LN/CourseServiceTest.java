package org.onlinecourse401.LN;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.onlinecourse401.project.backEnd.repositories.CourseRepositoryInterface;
import org.onlinecourse401.project.backEnd.service.allServices.CourseService;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;



public class CourseServiceTest {


// тест проверяет, что метод createContentList класса CourseService корректно
// создает список содержимого (List<String>) из двух переданных строк
// content1 и content2


@Test
public void testCreateContentList() {
    CourseService courseService = new CourseService(mock(CourseRepositoryInterface.class));
    assertEquals(2, courseService.createContentList("Content 1", "Content 2").size());
}





    /* //тот же тест, что ниже, но по другому прописан (НННЕЕЕ РАБОТАЕТ)
        @Test
        public void testFindCourseById_Found() {
            CourseRepositoryInterface courseRepository = mock(CourseRepositoryInterface.class);
            when(courseRepository.findById(anyInt())).thenReturn(java.util.Optional.of(new Course()));
            CourseService courseService = new CourseService(courseRepository);
            assertNotNull(courseService.findCourseById(1));
        }
        */

/*   //ТЕСТ НННЕЕЕЕ РАБОТАЕТ
    @Test
    public void testFindCourseById_Found() {
        // Создаем макет репозитория
        CourseRepositoryInterface courseRepository = mock(CourseRepositoryInterface.class);

        // Настраиваем макет репозитория для возвращения объекта Course при вызове метода findById
        when(courseRepository.findById(1)).thenReturn(Optional.of(new Course()));

        // Создаем экземпляр CourseService с использованием макета репозитория
        CourseService courseService = new CourseService(courseRepository);

        // Проверяем, что метод findCourseById не возвращает null
        assertNotNull(courseService.findCourseById(1));
    }
*/
@Test
public void testFindAll() {
        CourseRepositoryInterface courseRepository = mock(CourseRepositoryInterface.class);
        when(courseRepository.findAll()).thenReturn(new ArrayList<>());
        CourseService courseService = new CourseService(courseRepository);
        assertTrue(courseService.findAll().isEmpty());
    }

@Test
public void testPrintAllCourses() {
        CourseRepositoryInterface courseRepository = mock(CourseRepositoryInterface.class);
        CourseService courseService = new CourseService(courseRepository);
        courseService.printAllCourses(); // Just checking that no exceptions occur
    }

@Test
   public void testPrintAllCoursesFullInfo() {
        CourseRepositoryInterface courseRepository = mock(CourseRepositoryInterface.class);
        CourseService courseService = new CourseService(courseRepository);
        courseService.printAllCoursesFullInfo();
        // Просто проверяю, что исключений не возникает
    }
}






