package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.StudentDto;
import org.onlinecourse401.project.backEnd.entity.Student;
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

//Step1:
    //1.metod: createListCoursesByStudent входные параметры метода: колекция всех курсов школы и Integer courseId
    //
    // пройтись по коллекции из CourseRepisitory и сравнить по id,
    // na vyhod: List<Course> coursesByStudent

//Step2:
     //2.metod: aktualizirovanie parametrov studenta:
    // setCoursesByStudentInStudent(List<Course> coursesByStudent, String email) {
    // for (Student student : List<Student> students)
    // if (student.getEmail().equals(email)) {
    //  Student.setCoursesByStudent(coursesByStudent)
    // na vyhod: Student s obnovlennymi dannymi

//Step3:

    //  kollekcija sozdaetsja v klasse TestResultService, potom:

//Step5:
    //3. metod: aktualizirovanie parametrov studenta s kollekciej TestResult,
    // setTestResultsToStudent(Map<Course, List<TestResult>> courseTestResults, String email) {
    // for (Student student : List<Student> students)
    // if (student.getEmail().equals(email)) {
    //Map<Course, List<TestResult>> Student.getCoursesByStudent().getCourse(),courseTestResults
    //  Student.setCourseTestResults(courseTestResults)


}
