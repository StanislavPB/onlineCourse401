package org.onlinecourse401.project.backEnd.service.allServices;


import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.CourseDto;

import org.onlinecourse401.project.backEnd.dto.TestControlDto;
import org.onlinecourse401.project.backEnd.entity.Course;

import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestControl;
import org.onlinecourse401.project.backEnd.repositories.CourseRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//addNewCourse (Request: CourseDto, Response: ClientResponse),
// remove (Request: CourseDto, Response: ClientResponse),
// find by id (Request: Integer courseId, Response:  ClientResponse<Course>)
// findAll
public class CourseService {
    private final CourseRepositoryInterface courseRepository;


    public CourseService(CourseRepositoryInterface courseRepository) {
        this.courseRepository = courseRepository;
    }
    public List<String> createContentList(String content1, String content2){
        List<String> newContentList = new ArrayList<>();
        newContentList.add(content1);
        newContentList.add(content2);
        return newContentList;
    }
    public CourseDto createCourseDto(String courseName, String description,List<String> newContentList,TestControlDto testDto){
        CourseDto courseDto = new CourseDto(courseName,description, newContentList,testDto);
        return courseDto;
    }

    public ClientResponseDto<String> addNewCourse(CourseDto newCourseDto, TestControl testControl){
       // validationRequest.checkRequest(newCourseDto);
        Course newCourse = new Course(null, newCourseDto.getCourseName(), newCourseDto.getDescription(), newCourseDto.getContent(),testControl);
       courseRepository.add(newCourse);
        if (newCourse != null) {
            return new ClientResponseDto<>(200, newCourse.getCourseName(), "Course is added successful.");
        } else {
            return new ClientResponseDto<>(250, newCourse.getCourseName(), "Course is not added.");
        }
    }
    public Course findCourseById(Integer courseId) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent()) {
            Course currentCourse = optionalCourse.get();
            return currentCourse;
        } else {
            // Handle the case when either student or course is not found
            throw new IllegalArgumentException("Course not found");
        }
    }
    public List<Course> findAll() {
      return   courseRepository.findAll();
    }
    public void printAllCourses() {
        List<Course> allCourses = courseRepository.findAll();
        for (Course course:allCourses) {
            System.out.println("Course nr.: "+course.getId()+"\n Title: "+course.getCourseName()+"\n Description: "+course.getDescription());
        }
    }

    public void printAllCoursesFullInfo() {
        findAll().forEach(course -> System.out.println(course));
    }
}
