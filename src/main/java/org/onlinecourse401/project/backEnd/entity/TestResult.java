package org.onlinecourse401.project.backEnd.entity;

import java.util.List;

public class TestResult {
    private Integer courseId;
    private List<Integer> studentAnswers;
    private Double currentGrade;

    public TestResult(Integer courseId, List<Integer> studentAnswers, Double currentGrade) {
        this.courseId = courseId;
        this.studentAnswers = studentAnswers;
        this.currentGrade = currentGrade;
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

    public Double getCurrentGrade() {
        return currentGrade;
    }

    public void setCurrentGrade(Double currentGrade) {
        this.currentGrade = currentGrade;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "courseId=" + courseId +
                ", studentAnswers=" + studentAnswers +
                ", currentGrade=" + currentGrade +
                '}';
    }
}
