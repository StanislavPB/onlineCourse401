package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.entity.Question;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestControl;
import org.onlinecourse401.project.backEnd.entity.TestResult;
import org.onlinecourse401.project.frontEnd.util.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestResultService {
    UserInput ui = new UserInput();

//Step1: metod prohozhdenija testa / dachi otvetov na voprosy:
   public List<Integer> createStudentAnswers(Student student, Integer idCourse, Integer idTest) {
       TestControl currentTest = student.getCoursesByStudent().get(idCourse).getTests().get(idTest);
        String test1Title = currentTest.getTitle();
        System.out.println("Evaluate test: " + test1Title);

        Question question1 = currentTest.getQuestions().get(0);
        System.out.println("Question nr.1: " + question1);
        List<String> optionsQ1 = question1.getAnswerOptions();
        int studentAnswerQ1 = ui.inputInteger("Please choose one answer option: " + optionsQ1);

       Question question2 = currentTest.getQuestions().get(1);
       System.out.println("Question nr.2: " + question2);
       List<String> optionsQ2 = question2.getAnswerOptions();
       int studentAnswerQ2 = ui.inputInteger("Please choose one answer option: " + optionsQ2);

       Question question3 = currentTest.getQuestions().get(2);
       System.out.println("Question nr.3: " + question3);
       List<String> optionsQ3 = question3.getAnswerOptions();
       int studentAnswerQ3 = ui.inputInteger("Please choose one answer option: " + optionsQ3);

        List<Integer> studentAnswers = new ArrayList<>();
        studentAnswers.add(studentAnswerQ1);
        studentAnswers.add(studentAnswerQ2);
        studentAnswers.add(studentAnswerQ3);


        return studentAnswers;
    }

//Step2: metod ocenki otvetov
    public Integer calculateCurrentGrade(Student student, Integer idCourse, Integer idTest, List<Integer> studentAnswers) {
        Integer rightOptionQ1 = student.getCoursesByStudent().get(idCourse).getTests().get(idTest).getQuestions().get(0).getCorrectAnswer();
        Integer rightOptionQ2 = student.getCoursesByStudent().get(idCourse).getTests().get(idTest).getQuestions().get(1).getCorrectAnswer();
        Integer rightOptionQ3 = student.getCoursesByStudent().get(idCourse).getTests().get(idTest).getQuestions().get(2).getCorrectAnswer();

        List<Integer> rightOptions = new ArrayList<>();
        rightOptions.add(rightOptionQ1);
        rightOptions.add(rightOptionQ2);
        rightOptions.add(rightOptionQ3);

        Integer currentGrade = 0;
        for (int i = 0; i < rightOptions.size(); i++) {
                if (rightOptions.get(i).equals(studentAnswers.get(i))) {
                    currentGrade++; // Увеличиваем оценку на 1 за каждое совпадение
                }

        }
        return currentGrade;

        }
        public List<TestResult> createTestResult(Integer courseId, List<Integer> studentAnswers, List<Integer>currentGrade){

       return testTestResultList;
        }
/*
Step3: sozdaem eksempljar klassa TestResult
    public TestResult createTestResult(Integer courseId, Integer currentGrade, Map<Integer, Integer> studentAnswers) {
    TestResult testResult = new TestResult(Integer courseId, Integer currentGrade,Map<Integer, Integer> studentAnswers)
    return testResult;
    }
Step4: sozdaem collecciju iz TestResult ili Map<Course, List<TestResult>> ?????????
    List<TestResult>> courseTestResults
    metod:
    public Map<Course, List<TestResult>> createTestResults(List<Student> students){
    for (Student student : List<Student> students) {
    Course key = student.getCoursesByStudent().getCourse()

    }



    }

 */

}
