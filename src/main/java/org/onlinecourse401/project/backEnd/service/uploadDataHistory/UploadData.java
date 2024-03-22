package org.onlinecourse401.project.backEnd.service.uploadDataHistory;

import org.onlinecourse401.project.backEnd.entity.Course;
import org.onlinecourse401.project.backEnd.entity.TestControl;
import org.onlinecourse401.project.backEnd.repositories.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UploadData {
    /*
    private final CourseRepositoryInterface courseRepository;
    private final QuestionRepositoryInterface questionRepository;
    private final TestControlRepositoryInterface testControlRepository;
    private final StudentRepositoryInterface studentRepository;
    private final TestResultRepositoryInterface testResultRepository;

    public UploadData(CourseRepositoryInterface courseRepository, QuestionRepositoryInterface questionRepository, TestControlRepositoryInterface testControlRepository, StudentRepositoryInterface studentRepository, TestResultRepositoryInterface testResultRepository) {
        this.courseRepository = courseRepository;
        this.questionRepository = questionRepository;
        this.testControlRepository = testControlRepository;
        this.studentRepository = studentRepository;
        this.testResultRepository = testResultRepository;
    }
    private TestControl uploadTestControl1() {
        TestControl testControl1 = new TestControl();
        return testControl1;
    }
    public void uploadCourseData() {
        String filePathCourses = "src/homeworks/homework_43/task_03/csv_file_input_data.csv"; // id, courseName, description, content
        List<String[]> data = readCSVFile(filePathCourses);

        if (data != null) {
            for (String[] line : data) {
                try {
                    Integer id = Integer.parseInt(line[0]);
                    String courseName = line[1];
                    String description = line[2];

                    // Initialize content list and add content elements
                    List<String> content = new ArrayList<>();
                    for (int i = 3; i < line.length; i++) {
                        content.add(line[i]);
                    }

                    TestControl test = uploadTestControl1();

                    courseRepository.add(new Course(id, courseName, description, content, test));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    // Handle parsing or index out of bounds exceptions
                    System.out.println("Error parsing data: " + e.getMessage());
                }
            }
            System.out.println(courseRepository.findAll());
        } else {
            System.out.println("Failed to read data from the CSV file.");
        }
    }


    public static List<String[]> readCSVFile(String path) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
            return null;
        }
        return data;
    }

     */
}

