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

    @Override
    public TestResult add(TestResult newTestResult) {
        testResults.add(newTestResult);
        return newTestResult;
    }
}
