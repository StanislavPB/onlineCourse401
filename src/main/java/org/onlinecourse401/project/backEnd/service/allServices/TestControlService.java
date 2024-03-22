package org.onlinecourse401.project.backEnd.service.allServices;

import org.onlinecourse401.project.backEnd.dto.QuestionDto;
import org.onlinecourse401.project.backEnd.dto.TestControlDto;
import org.onlinecourse401.project.backEnd.entity.Question;
import org.onlinecourse401.project.backEnd.entity.TestControl;
import org.onlinecourse401.project.backEnd.repositories.TestControlRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

public class TestControlService {
    private final TestControlRepositoryInterface testControlRepository;


    public TestControlService(TestControlRepositoryInterface testControlRepository) {
        this.testControlRepository = testControlRepository;
    }
    public TestControlDto creatTestControlDto(String title, List<QuestionDto> questionsDto){
        TestControlDto testControlDto = new TestControlDto(title,questionsDto);
        return testControlDto;
    }
    public List<TestControlDto> createTestControlDtoList(TestControlDto testControlDto){
        List<TestControlDto> testControlDtoList = new ArrayList<>();
        testControlDtoList.add(testControlDto);
        return testControlDtoList;
    }
    public List<TestControl> createTestControlList(List<TestControlDto> testControlDtoList, List<Question> questions){
        for (TestControlDto testControlDto : testControlDtoList){
            TestControl newTestControl = new TestControl(null,testControlDto.getTitle(),questions);
           testControlRepository.add(newTestControl);
            // repository.add(.... в том чмсле - результат работы метода questionService.createQuestionList(testControlDto.getQuestionDto()))
        }
        return testControlRepository.findAll();
    }
}

