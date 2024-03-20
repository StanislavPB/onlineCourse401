package org.onlinecourse401.project.backEnd.repositories;

import org.onlinecourse401.project.backEnd.entity.TestResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestResultRepository implements TestResultRepositoryInterface{
    private List<TestResult> testResults;

    public TestResultRepository() {
        this.testResults = new ArrayList<>();
    }

    public List<TestResult> getTestResults() {
        return testResults;
    }

    @Override
    public String toString() {
        return "результат тестирования:" + "Результат теста - " + testResults;
    }


    @Override
    public List<TestResult> add(TestResult testResult) {
        List<TestResult> results= new ArrayList<>();
        results.add(testResult);
        return results;
    }
}
