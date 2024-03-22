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

    public TestControl createTestControl(TestControlDto testControlDto, List<Question> questions){
            TestControl newTestControl = new TestControl(null,testControlDto.getTitle(),questions);
           testControlRepository.add(newTestControl);
        return newTestControl;
    }
}

