package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.StudentDto;
import org.onlinecourse401.project.backEnd.entity.Course;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestResult;
import org.onlinecourse401.project.backEnd.repositories.CourseRepositoryInterface;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;
import org.onlinecourse401.project.backEnd.repositories.TestResultRepositoryInterface;
import org.onlinecourse401.project.backEnd.service.validation.ValidationRequest;

import java.util.ArrayList;
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
public Student addCourseToStudent(Student student, Integer idCourse) {
    Optional<Course> optionalCourse = courseRepository.findById(idCourse);

    if (optionalCourse.isPresent()) {
        Course course = optionalCourse.get();

        // Add the course to the student's list of courses
        student.setCourseByStudent(course);

        // Save the updated student (assuming you have a method to save/update students)
        studentRepository.update(student);

        // Return the list of courses associated with the student
        return student;
    } else {
        // Handle the case when either student or course is not found
        throw new IllegalArgumentException("Course not found");
    }
}

    public void printCourseDataByStudent(Student student) {

            System.out.println("Course nr.: "+student.getCourseByStudent().getId());
            System.out.println("Title: "+student.getCourseByStudent().getCourseName());
            System.out.println("Description: "+student.getCourseByStudent().getDescription());
            System.out.println("Content1: "+student.getCourseByStudent().getContent().get(0));
            System.out.println("Content2: "+student.getCourseByStudent().getContent().get(1));

    }
/*
    public Student addTestResultsToStudent(Integer studentId, List<TestResult> allTestResults){
       Student student = findStudentById(studentId);
        List<TestResult> studentTestResults = student.getCourseTestResults();

        for (TestResult result : allTestResults) {
            if (result.getStudentId().equals(student.getId())) {
             //   List<TestResult> oneStudentTestResults = new ArrayList<>();
                studentTestResults.add(result);
            //    oneStudentTestResults.add(result);
            //    student.setCourseTestResults(oneStudentTestResults);
                student.setCourseTestResults(studentTestResults);
            } else {
                student.setCourseTestResults(studentTestResults);
            }
        }
        studentRepository.update(student);

        return student;
    }

 */
public Student addTestResultsToStudent(Integer studentId, List<TestResult> allTestResults) {
    Student student = findStudentById(studentId);
    List<TestResult> studentTestResults = new ArrayList<>();

    for (TestResult result : allTestResults) {
        if (result.getStudentId().equals(student.getId())) {
            studentTestResults.add(result);
        }
    }

    // Set the test results for the student
    student.setCourseTestResults(studentTestResults);

    // Update the student in the repository
    studentRepository.update(student);

    return student;
}
    public Student findStudentById(Integer idStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(idStudent);
        if (optionalStudent.isPresent() ) {
            Student currentStudent = optionalStudent.get();
            return currentStudent;
        } else {
            // Handle the case when either student or course is not found
            throw new IllegalArgumentException("Student not found");
        }
    }
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }
}
