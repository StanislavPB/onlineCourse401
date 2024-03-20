package org.onlinecourse401.entity;

import java.util.List;

public class TestResult {
    private int courseId;
    private List<Integer> studentAnswers;
    private double currentGrade;

    public TestResult(int courseId, List<Integer> studentAnswers, double currentGrade) {
        this.courseId = courseId;
        this.studentAnswers = studentAnswers;
        this.currentGrade = currentGrade;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public List<Integer> getStudentAnswers() {
        return studentAnswers;
    }

    public void setStudentAnswers(List<Integer> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }

    public double getCurrentGrade() {
        return currentGrade;
    }

    public void setCurrentGrade(double currentGrade) {
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
