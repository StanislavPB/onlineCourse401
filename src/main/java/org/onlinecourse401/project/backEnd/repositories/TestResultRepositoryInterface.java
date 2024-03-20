package org.onlinecourse401.project.backEnd.repositories;

import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestResult;

import java.util.List;
import java.util.Optional;

public interface TestResultRepositoryInterface {
//    public TestResult add(TestResult testResult);
//    public Optional<TestResult> findById(Integer courseId);
    public List<TestResult> add(TestResult testResult);



}
