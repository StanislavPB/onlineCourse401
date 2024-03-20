package org.onlinecourse401.project.backEnd.repositories;

import org.onlinecourse401.project.backEnd.entity.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository implements CourseRepositoryInterface{
    private Integer courseId = 0;

    private List<Course> courses;

    public CourseRepository() {
        this.courses = new ArrayList<>();
    }

    @Override
    public Course add(Course newCourse) {
        newCourse.setId(++courseId);
        courses.add(newCourse);
        return newCourse;
    }

    @Override
    public Optional<Course> findById(Integer id) {
        for (Course course : courses){
            if (course.getId().equals(id));
        }
        return Optional.empty();
    } 

    @Override
    public Optional<Course> findByCourseName(String courseName) {
        for (Course course : courses){
            if (course.getCourseName().equals(courseName));
        }
        return Optional.empty();
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }
}
