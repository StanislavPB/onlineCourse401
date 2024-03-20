package org.onlinecourse401.project.backEnd.repositories;

import org.onlinecourse401.project.backEnd.entity.Course;
import org.onlinecourse401.project.backEnd.entity.TestControl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CourseRepository implements CourseRepositoryInterface {
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
        for (Course course : courses) {
            if (course.getId().equals(id))
            {
                return Optional.of(course);
            }

        } return Optional.empty();
    }


        @Override
        public Optional<Course> findByCourseName(String courseName){
            for (Course course : courses) {
                if (course.getCourseName().equals(courseName))
                {
                    return Optional.of(course);
                }
            } return Optional.empty();
        }


        @Override
        public List<Course> findAll () {
            return courses;
        }

    @Override
    public boolean remove(Integer courseId) {
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getId().equals(courseId)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }
}

