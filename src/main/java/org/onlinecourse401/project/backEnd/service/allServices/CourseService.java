package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.CourseDto;
import org.onlinecourse401.project.backEnd.dto.TestControlDto;
import org.onlinecourse401.project.backEnd.entity.Course;
import org.onlinecourse401.project.backEnd.repositories.CourseRepositoryInterface;

import java.util.List;

//addNewCourse (Request: CourseDto, Response: ClientResponse),
// remove (Request: CourseDto, Response: ClientResponse),
// find by id (Request: Integer courseId, Response:  ClientResponse)
public class CourseService {

    private final CourseRepositoryInterface courseRepository;


    public CourseService(CourseRepositoryInterface courseRepository) {
        this.courseRepository = courseRepository;
    }

    public ClientResponseDto<Course> addNewCourse(CourseDto newCourseDto){
        //List<Course> courses = courseRepository.add(newCourseDto);

       // validationRequest.checkRequest(newCourseDto);
        Course courseForAdd = new Course(newCourseDto.getCourseName(),newCourseDto.getDescription(),newCourseDto.getContent(),newCourseDto.getTests());
        courseRepository.add(courseForAdd);
        if (courseForAdd != null) {
            return new ClientResponseDto<>(200, courseForAdd, "Course is added successful.");
        } else {
            return new ClientResponseDto<>(250, courseForAdd, "Course is not added.");
        }
    }


}
