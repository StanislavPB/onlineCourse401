package org.onlinecourse401.project.backEnd.service.allServices;

import jdk.incubator.vector.VectorOperators;
import org.onlinecourse401.project.backEnd.dto.ClientResponseDto;
import org.onlinecourse401.project.backEnd.dto.CourseDto;
import org.onlinecourse401.project.backEnd.dto.QuestionDto;
import org.onlinecourse401.project.backEnd.dto.TestControlDto;
import org.onlinecourse401.project.backEnd.entity.Course;
import org.onlinecourse401.project.backEnd.entity.Question;
import org.onlinecourse401.project.backEnd.entity.TestControl;
import org.onlinecourse401.project.backEnd.repositories.CourseRepositoryInterface;

import java.util.List;

//addNewCourse (Request: CourseDto, Response: ClientResponse),
// remove (Request: CourseDto, Response: ClientResponse),
// find by id (Request: Integer courseId, Response:  ClientResponse)
public class CourseService {

    private final CourseRepositoryInterface courseRepository;


    public CourseService(CourseRepositoryInterface courseRepository) {
        this.courseRepository = courseRepository;
    }

    public ClientResponseDto<Course> addNewCourse(CourseDto newCourseDto){

        List<TestControl> controlTestList = testControlService.createTestControlList(newCourseDto.getTests());

        внутри testControlService.

        public List<TestControl> createTestControlList(List<TestControlDto> controlTestList){
            for (TestControlDto testControlDto : controlTestList){
                TestControl newTestControl = repository.add(.... в том чмсле - результат работы метода questionService.createQuestionList(testControlDto.getQuestionDto()))
            }
        }



        внутри questionService.

        public List<Question> createQuestionList(List< QuestionDto > questionDtoList){
            for (QuestionDto questionDto : questionDtoList){
                Question newQuestion =  questionRepository.ad(данные из questionDto)}
        }




        //List<Course> courses = courseRepository.add(newCourseDto);

        /*

        1) проходимся по списку List<TestControlDto> для каждого элемента создаем TestControl
        2)для этого проходимся по List<QuestionDto> и из его элементов создаем List<Question>

        у вас есть CourseDto в котором есть List<TestControlDto> в каждом элементе котрого есть
        List<QuestionDto>

        чтобы создать новый Course вам надо создать объект List<TestControl> где каждывй элемент
        будет иметь у себя List<Question> которые надо до это момента создать из QuestionDto



        1. взять из newCourseDto информацию об объекте где хранится список тестов
        2. поскольку в newCourseDto хранится не сами тесты, а их dto то надо:
            - создать в репозитории тестов новый тест используя данные из TestControlDto
            - в результате этого создания у вас появится List<TestControl> в которых будут уже объекты не dto а entity
            - и при моздании нового курса вы долджны в конструктор передать ссылку на этот list
         */
       // validationRequest.checkRequest(newCourseDto);

        Course courseForAdd = new Course(newCourseDto.getCourseName(),newCourseDto.getDescription(),newCourseDto.getContent(),newCourseDto.getTests());
        courseRepository.add(courseForAdd);
        if (courseForAdd != null) {
            return new ClientResponseDto<>(200, courseForAdd, "Course is added successful.");
        } else {
            return new ClientResponseDto<>(250, courseForAdd, "Course is not added.");
        }
    }


}
