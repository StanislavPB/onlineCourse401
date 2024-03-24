package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.entity.Question;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestControl;
import org.onlinecourse401.project.backEnd.entity.TestResult;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;
import org.onlinecourse401.project.backEnd.repositories.TestResultRepositoryInterface;
import org.onlinecourse401.project.backEnd.service.validation.ValidationRequest;
import org.onlinecourse401.project.frontEnd.util.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestResultService {
    UserInput ui = new UserInput();
    private final StudentRepositoryInterface studentRepository;

    private final TestResultRepositoryInterface testResultRepository;
    private final ValidationRequest validationRequest;

    public TestResultService(StudentRepositoryInterface studentRepository, TestResultRepositoryInterface testResultRepository, ValidationRequest validationRequest) {
        this.studentRepository = studentRepository;
        this.testResultRepository = testResultRepository;
        this.validationRequest = validationRequest;
    }
    public List<Integer> createStudentAnswers(Integer idStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(idStudent);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            TestControl currentTest = student.getCourseByStudent().getTest();
            String testTitle = currentTest.getTitle();
            System.out.println("---------EVALUATE TEST: ---------");
            System.out.println(testTitle);

            List<Integer> studentAnswers = new ArrayList<>();
            int numQuestions = currentTest.getQuestions().size();

            // Определение диапазона вопросов в зависимости от курса и создание ответов студента
            int startQuestionIndex = (student.getCourseByStudent().getId() - 1) * 3;
            int endQuestionIndex = startQuestionIndex + 3;
            for (int i = startQuestionIndex; i < endQuestionIndex; i++) {
                Question question = currentTest.getQuestions().get(i);
                System.out.println("Question nr." + (i - startQuestionIndex + 1) + ": " + question.getText());
                List<String> options = question.getAnswerOptions();
                int studentAnswer = validationRequest.inputIntegerWithValidation(ui, "Answer options: " + "\n" + options.get(0) + "\n" + options.get(1) + "\n" + options.get(2) + "\n" + "Please choose number: ");
                studentAnswers.add(studentAnswer);
            }

            return studentAnswers;
        } else {
            // Handle the case when either student or course is not found
            throw new IllegalArgumentException("Student not found");
        }
    }
//Step2: metod ocenki otvetov
    public Integer calculateCurrentGrade(Integer idStudent, List<Integer> studentAnswers) {
        Optional<Student> optionalStudent = studentRepository.findById(idStudent);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            List<Integer> rightOptions = new ArrayList<>();
          //  int numQuestions = currentTest.getQuestions().size();

            // Определение диапазона вопросов в зависимости от курса и создание ответов студента
            int startQuestionIndex = (student.getCourseByStudent().getId() - 1) * 3;
            int endQuestionIndex = startQuestionIndex + 3;
            for (int i = startQuestionIndex; i < endQuestionIndex; i++) {
                Integer rightOption = student.getCourseByStudent().getTest().getQuestions().get(i).getCorrectAnswer();
                rightOptions.add(rightOption);
            }
        Integer currentGrade = 0;
        for (int i = 0; i < rightOptions.size(); i++) {
                if (rightOptions.get(i).equals(studentAnswers.get(i))) {
                    currentGrade++; // Увеличиваем оценку на 1 за каждое совпадение
                }
        }
        return currentGrade;
        } else {
            // Handle the case when either student or course is not found
            throw new IllegalArgumentException("Student not found");
        }
    }
    /*
    //Step2: metod ocenki otvetov
    public Integer calculateCurrentGrade(Integer idStudent, List<Integer> studentAnswers) {
        Optional<Student> optionalStudent = studentRepository.findById(idStudent);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();

            Integer rightOptionQ1 = student.getCourseByStudent().getTest().getQuestions().get(0).getCorrectAnswer();
            Integer rightOptionQ2 = student.getCourseByStudent().getTest().getQuestions().get(1).getCorrectAnswer();
            Integer rightOptionQ3 = student.getCourseByStudent().getTest().getQuestions().get(2).getCorrectAnswer();

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
        } else {
            // Handle the case when either student or course is not found
            throw new IllegalArgumentException("Student not found");
        }
    }

     */
        public TestResult createTestResult(Integer idStudent, List<Integer> studentAnswers, Integer currentGrade){
            Optional<Student> optionalStudent = studentRepository.findById(idStudent);
            if (optionalStudent.isPresent()) {
                Student student = optionalStudent.get();
        TestResult testResult = new TestResult(student.getId(),student.getCourseByStudent().getId(),studentAnswers,currentGrade);
        return testResult;
            } else {
                // Handle the case when either student or course is not found
                throw new IllegalArgumentException("Student not found");
            }
        }
        public List<TestResult> addToTestResults(TestResult testResult) {

                testResultRepository.add(testResult);

            return testResultRepository.findAll();
        }

}
