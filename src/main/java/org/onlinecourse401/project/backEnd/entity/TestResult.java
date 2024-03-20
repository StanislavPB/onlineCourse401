package org.onlinecourse401.project.backEnd.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestResult {
    private Integer courseId;
    private Map<Integer, Integer> studentAnswers;
    private Integer countOfRightAnswers;

    public TestResult(Integer courseId, Integer currentGrade) {
        this.courseId = courseId;
        this.studentAnswers = new HashMap<>();
        this.countOfRightAnswers = currentGrade;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }


    public Map<Integer, Integer> getStudentAnswers() {
        return studentAnswers;
    }

    public void setStudentAnswers(Map<Integer, Integer> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }

    public Integer getCurrentGrade() {
        return countOfRightAnswers;
    }

    public void setCurrentGrade(Double currentGrade) {
        this.countOfRightAnswers = countOfRightAnswers;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "courseId=" + courseId +
                ", studentAnswers=" + studentAnswers +
                ", currentGrade=" + countOfRightAnswers +
                '}';
    }
}
