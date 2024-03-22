package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.StudentDto;
import org.onlinecourse401.project.backEnd.entity.Course;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestResult;
import org.onlinecourse401.project.backEnd.repositories.CourseRepositoryInterface;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;
import org.onlinecourse401.project.backEnd.service.validation.ValidationRequest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

//(add (Request: StudentDto, Response: ClientResponse), remove
// (Request: StudentDto, Response: ClientResponse), find by id
// (Request: Integer studentId, Response:  ClientResponse)
public class StudentService {

    private final StudentRepositoryInterface studentRepository;
    private final ValidationRequest validationRequest;
    private final CourseRepositoryInterface courseRepository;

    public StudentService(StudentRepositoryInterface studentRepository, ValidationRequest validationRequest, CourseRepositoryInterface courseRepository) {
        this.studentRepository = studentRepository;
        this.validationRequest = validationRequest;
        this.courseRepository = courseRepository;
    }

    public ClientResponseDto<Student> addNewStudent(StudentDto studentDto) {
        validationRequest.checkEmail(studentDto);
        validationRequest.checkPassword(studentDto);
        Student newStudent = new Student(null, studentDto.getName(), studentDto.getEmail(), studentDto.getPassword());
        studentRepository.add(newStudent);
        if (newStudent.getId() > 0) {
            return new ClientResponseDto<>(200, newStudent, "Your account is created.");
        } else {
            return new ClientResponseDto<>(250, newStudent, "Your account not created. Error! Your added data are empty.");
        }
    }

//Step1:
    //1.metod: sozdaem list / korzinu kursov,kotorye hochet projti student:
public Course addCourseToStudent(Integer idStudent, Integer idCourse) {
    Optional<Course> optionalCourse = courseRepository.findById(idCourse);
    Optional<Student> optionalStudent = studentRepository.findById(idStudent);

    if (optionalStudent.isPresent() && optionalCourse.isPresent()) {
        Student student = optionalStudent.get();
        Course course = optionalCourse.get();

        // Add the course to the student's list of courses
        student.setCourseByStudent(course);

        // Save the updated student (assuming you have a method to save/update students)
        studentRepository.add(student);

        // Return the list of courses associated with the student
        return student.getCourseByStudent();
    } else {
        // Handle the case when either student or course is not found
        throw new IllegalArgumentException("Student or Course not found");
    }
}

//Step2:
     //2.metod: aktualizirovanie parametrov studenta:
    // setCoursesByStudentInStudent(List<Course> coursesByStudent, String email) {
    // for (Student student : List<Student> students)
    // if (student.getEmail().equals(email)) {
    //  Student.setCoursesByStudent(coursesByStudent)
    // na vyhod: Student s obnovlennymi dannymi

/*
    public Student addTestResultsToStudent (Integer idStudent, List<TestResult> testResults, Integer idCourse){

        return student;
    }

 */
//Step3:

    //  kollekcija List<TestResult>> courseTestResults ili ??? Map<Course, List<TestResult>>
    //  sozdaetsja v klasse TestResultService, potom:

//Step5:
    //3. metod: aktualizirovanie parametrov studenta s kollekciej TestResult,
    // setTestResultsToStudent(Map<Course, List<TestResult>> courseTestResults, String email) {
    // for (Student student : List<Student> students)
    // if (student.getEmail().equals(email)) {
    //Map<Course, List<TestResult>> Student.getCoursesByStudent().getCourse(),courseTestResults
    //  Student.setCourseTestResults(courseTestResults)


}
