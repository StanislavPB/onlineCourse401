package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.CourseDto;
import org.onlinecourse401.project.backEnd.dto.StudentDto;
import org.onlinecourse401.project.backEnd.entity.Course;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestControl;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;

import java.util.List;

//(add (Request: StudentDto, Response: ClientResponse), remove
// (Request: StudentDto, Response: ClientResponse), find by id
// (Request: Integer studentId, Response:  ClientResponse)
public class StudentService {

    private final StudentRepositoryInterface studentRepository;

    public StudentService(StudentRepositoryInterface studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ClientResponseDto<String> addNewStudent(StudentDto studentDto) {
        //validation
        Student newStudent = new Student(null, null, studentDto.getEmail(), studentDto.getPassword());
        studentRepository.add(newStudent);
        if (newStudent.getId() > 0) {
            return new ClientResponseDto<>(200, newStudent.getEmail(), "Your account is created.");
        } else {
            return new ClientResponseDto<>(250, newStudent.getEmail(), "Your account not created. Error! Your added data are empty.");
        }
    }








    //добавление курса к студенту в корзину курсов из общей коллекции всех курсов
    // входные параметры метода: колекция всех курсов школы и Integer courseId
    //
    // пройтись по коллекции из CourseRepisitory и сравнить по id,
}
