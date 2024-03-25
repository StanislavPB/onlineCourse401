package org.onlinecourse401.TesterLN;

public class StudentServiceTest {
    /*
    private ValidationRequest validationRequest;
    private StudentRepositoryInterface studentRepository;

    @Before
    public void setUp() {
        validationRequest = mock(ValidationRequest.class);
        studentRepository = mock(StudentRepositoryInterface.class);
    }

    @Test
    public void testAddNewStudent_Success() {
        StudentDto studentDto = new StudentDto("John Doe", "john@example.com", "password123");

        // Подготовка мок объекта репозитория


        when(studentRepository.add(any(Student.class))).thenReturn(new Student(1L, "John Doe", "john@example.com", "password123"));

        // Создаем сервис
        StudentService studentService = new StudentService(validationRequest, studentRepository);

        // Выз. метод котор.тестир
        ClientResponseDto<Student> response = studentService.addNewStudent(studentDto);

        // Проверка результата
        assertEquals(200, response.getResponseCode());
        assertEquals("Your account is created.", response.getMessage());
    }

    @Test
    public void testAddNewStudent_Failure() {
        // Подготовка тест.дан.
        StudentDto studentDto = new StudentDto("John Doe", "john@example.com", "password123");

        // Подготовка мок объекта репозитория
        when(studentRepository.add(any(Student.class))).thenReturn(new Student());

        // Создание сервиса
        StudentService studentService = new StudentService(validationRequest, studentRepository);

        // Вызываем тест.метод
        ClientResponseDto<Student> response = studentService.addNewStudent(studentDto);

        // Проверка результата
        assertEquals(250, response.getResponseCode());
        assertEquals("Ваша учетная запись не создана. Ошибка! Добавленные вами данные пусты.", response.getMessage());
    }
   */

}
