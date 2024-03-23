package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.entity.Question;
import org.onlinecourse401.project.backEnd.entity.Student;
import org.onlinecourse401.project.backEnd.entity.TestControl;
import org.onlinecourse401.project.backEnd.entity.TestResult;
import org.onlinecourse401.project.backEnd.repositories.StudentRepositoryInterface;
import org.onlinecourse401.project.backEnd.repositories.TestResultRepositoryInterface;
import org.onlinecourse401.project.frontEnd.util.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestResultService {
    UserInput ui = new UserInput();
    private final StudentRepositoryInterface studentRepository;

    private final TestResultRepositoryInterface testResultRepository;

    public TestResultService(StudentRepositoryInterface studentRepository, TestResultRepositoryInterface testResultRepository) {
        this.studentRepository = studentRepository;
        this.testResultRepository = testResultRepository;
    }

    //Step1: metod prohozhdenija testa / dachi otvetov na voprosy:
   public List<Integer> createStudentAnswers(Integer idStudent) {
       Optional<Student> optionalStudent = studentRepository.findById(idStudent);
       if (optionalStudent.isPresent()) {
        Student student = optionalStudent.get();

        TestControl currentTest = student.getCourseByStudent().getTest();
        String test1Title = student.getCourseByStudent().getTest().getTitle();
        System.out.println("Evaluate test: " + test1Title);

        Question question1 = currentTest.getQuestions().get(0);
        System.out.println("Question nr.1: " + question1.getText());
        List<String> optionsQ1 = question1.getAnswerOptions();
        int studentAnswerQ1 = ui.inputInteger("Answer options: "+"\n"+optionsQ1.get(0)+"\n"+optionsQ1.get(1)+"\n"+optionsQ1.get(2)+"\n"+"Please choose number: ");

       Question question2 = currentTest.getQuestions().get(1);
       System.out.println("Question nr.2: " + question2.getText());
       List<String> optionsQ2 = question2.getAnswerOptions();
       int studentAnswerQ2 = ui.inputInteger("Answer options: "+"\n"+optionsQ2.get(0)+"\n"+optionsQ2.get(1)+"\n"+optionsQ2.get(2)+"\n"+"Please choose number: ");

       Question question3 = currentTest.getQuestions().get(2);
       System.out.println("Question nr.3: " + question3.getText());
       List<String> optionsQ3 = question3.getAnswerOptions();
       int studentAnswerQ3 = ui.inputInteger("Answer options: "+"\n"+optionsQ3.get(0)+"\n"+optionsQ3.get(1)+"\n"+optionsQ3.get(2)+"\n"+"Please choose number: ");

        List<Integer> studentAnswers = new ArrayList<>();
        studentAnswers.add(studentAnswerQ1);
        studentAnswers.add(studentAnswerQ2);
        studentAnswers.add(studentAnswerQ3);

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
