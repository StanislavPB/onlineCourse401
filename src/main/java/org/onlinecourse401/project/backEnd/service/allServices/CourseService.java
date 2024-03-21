package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.CourseDto;
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

    public ClientResponseDto<List<Course>> addNewCourse(){
        List<Course> courses = courseRepository.add(CourseDto);

        if (!tasks.isEmpty()) {
            return new ClientResponse<>(200, tasks, "Список задач");
        } else {
            return new ClientResponse<>(250, tasks, "База данных пустая!");
        }
    }
}
