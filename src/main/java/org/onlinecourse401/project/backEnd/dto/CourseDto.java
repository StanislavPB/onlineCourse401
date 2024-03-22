package org.onlinecourse401.project.backEnd.dto;
import org.onlinecourse401.project.backEnd.entity.TestControl;

import java.util.List;
public class CourseDto {
        private String courseName;
        private String description;
        private List<String> content;
        private TestControlDto test;

        // First constructor
        public CourseDto() {
        }

        // Second constructor
        public CourseDto(String courseName, String description) {
            this.courseName = courseName;
            this.description = description;
        }

        // Third constructor

    public CourseDto(String courseName, String description, List<String> content, TestControlDto test) {
        this.courseName = courseName;
        this.description = description;
        this.content = content;
        this.test = test;
    }


    // Getters and setters for other fields


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public TestControlDto getTest() {
        return test;
    }

    public void setTest(TestControlDto test) {
        this.test = test;
    }
}