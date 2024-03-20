package org.onlinecourse401.project.backEnd.repositories;

import org.onlinecourse401.project.backEnd.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepositoryInterface {
    public Course add(Course newCourse);

    public Optional<Course> findById(Integer id);

    public Optional<Course> findByCourseName(String courseName);

    public List<Course> findAll();
    public boolean remove(Integer courseId);
}
