package org.onlinecourse401.project.backEnd.repositories;

import org.onlinecourse401.project.backEnd.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepository implements StudentRepositoryInterface {

    private int studentId = 0;

    private List<Student> students;

    public StudentRepository() {

        this.students = new ArrayList<>();
    }

    @Override
    public Student add(Student newStudent) {
        newStudent.setId(++studentId);
        students.add(newStudent);

        return newStudent;
    }

    @Override
    public Optional<Student> findById(Integer id) {
        for (Student student : students){
            if (student.getId().equals(id));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Student> findByLastName(String LastName) {
        for (Student student : students){
            if (student.getLastName().equals(LastName));
        }
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        return students;
    }


}
