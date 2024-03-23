package org.onlinecourse401.project.backEnd.repositories;

import org.onlinecourse401.project.backEnd.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepositoryInterface {
    public Student add(Student newStudent);

    public Student update(Student studentToUpdate);
    public Optional<Student> findById(Integer id);

    public Optional<Student> findByLastName(String LastName);

    public List<Student> findAll();
    public boolean remove(Integer studentId);
}
