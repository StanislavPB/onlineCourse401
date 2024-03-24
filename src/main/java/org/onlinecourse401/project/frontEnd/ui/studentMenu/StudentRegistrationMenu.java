package org.onlinecourse401.project.frontEnd.ui.studentMenu;

import org.onlinecourse401.project.backEnd.service.allServices.StudentService;

public class StudentRegistrationMenu implements StudentMenuCommand {
    private final StudentService studentService;

    public StudentRegistrationMenu(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void executeCommand() {


    }

    @Override
    public String getMenuName() {
        return "Account is created";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
