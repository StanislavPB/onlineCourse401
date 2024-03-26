package org.onlinecourse401.LN;


import org.junit.Assert;
import org.junit.Test;
import org.onlinecourse401.project.backEnd.dto.QuestionDto;
import org.onlinecourse401.project.backEnd.service.allServices.QuestionService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

public class QuestionServiceTest {

    //createOptionsList работает правильно, он должен создавать
    // список с этими тремя значениями. Результат вызова этого метода
    // сравнивается с ожидаемым результатом, который представляет собой
    // список строк, содержащих "Option 1", "Option 2" и "Option 3".
    @Test
    public void testCreateOptionsList() {
        QuestionService questionService = new QuestionService(null);
        List<String> options = questionService.createOptionsList("Option 1", "Option 2", "Option 3");
        assertEquals(Arrays.asList("Option 1", "Option 2", "Option 3"), options);
    }


    //Проверяется, что возвращаемый объект questionDto не является null.
    //-----, что текст вопроса questionDto.getText() равен "Question text".
    //-----, что список вариантов ответа questionDto.getAnswerOptions() равен списку Arrays.asList("Option 1", "Option 2").
    //-----, что правильный ответ questionDto.getCorrectAnswer() равен 1.
    @Test
    public void testCreateQuestionDto() {
        QuestionService questionService = new QuestionService(null);
        QuestionDto questionDto = questionService.createQuestionDto("Question text", Arrays.asList("Option 1", "Option 2"), 1);
        Assert.assertNotNull(questionDto);
        assertEquals("Question text", questionDto.getText());
        assertEquals(Arrays.asList("Option 1", "Option 2"), questionDto.getAnswerOptions());
        assertEquals(Integer.valueOf(1), questionDto.getCorrectAnswer());
    }

    //Проверка, что возвращенный список questionDtoList не является null.
    //Проверка, что размер списка questionDtoList равен 3.
    @Test
    public void testCreateQuestionDtoList() {
        QuestionService questionService = new QuestionService(null);
        QuestionDto questionDto1 = new QuestionDto("Question 1", Arrays.asList("Option 1", "Option 2"), 1);
        QuestionDto questionDto2 = new QuestionDto("Question 2", Arrays.asList("Option 3", "Option 4"), 2);
        QuestionDto questionDto3 = new QuestionDto("Question 3", Arrays.asList("Option 5", "Option 6"), 3);
        List<QuestionDto> questionDtoList = questionService.createQuestionDtoList(questionDto1, questionDto2, questionDto3);
        Assert.assertNotNull(questionDtoList);
        assertEquals(3, questionDtoList.size());
    }

}
