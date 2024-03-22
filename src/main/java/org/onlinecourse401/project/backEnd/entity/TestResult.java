package org.onlinecourse401.project.backEnd.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestResult {
    private Integer courseId;
    private List<Integer> studentAnswers;
    private Integer countOfRightAnswers;



    public TestResult(Integer courseId, List<Integer> studentAnswers, Integer countOfRightAnswers) {
        this.courseId = courseId;
        this.studentAnswers = studentAnswers;
        this.countOfRightAnswers = countOfRightAnswers;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }


    public List<Integer> getStudentAnswers() {
        return studentAnswers;
    }

    public void setStudentAnswers(List<Integer> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }

    public Integer getCountOfRightAnswers() {
        return countOfRightAnswers;
    }

    public void setCountOfRightAnswers(Integer countOfRightAnswers) {
        this.countOfRightAnswers = countOfRightAnswers;
    }


    @Override
    public String toString() {
        return "TestResult{" +
                "courseId=" + courseId +
                ", studentAnswers=" + studentAnswers +
                ", countOfRightAnswers=" + countOfRightAnswers +
                '}';
    }
}
