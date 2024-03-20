package org.onlinecourse401.project.backEnd.dto;
import java.util.List;
public class CourseDto {
        private String courseName;
        private String description;
        private List<String> content;
        private List<TestControlDto> tests;

        // First constructor
        public CourseDto() {
        }

        // Second constructor
        public CourseDto(String courseName, String description) {
            this.courseName = courseName;
            this.description = description;
        }

        // Third constructor
        public CourseDto(String courseName, String description, List<String> content, List<TestControlDto> tests) {
            this.courseName = courseName;
            this.description = description;
            this.content = content;
            this.tests = tests;
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

        public List<TestControlDto> getTests() {
            return tests;
        }

        public void setTests(List<TestControlDto> tests) {
            this.tests = tests;
        }
    }