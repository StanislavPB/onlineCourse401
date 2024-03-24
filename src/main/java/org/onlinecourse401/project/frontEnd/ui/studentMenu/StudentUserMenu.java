package org.onlinecourse401.project.frontEnd.ui.studentMenu;

import org.onlinecourse401.project.frontEnd.ui.UserInputConsole;

public class StudentUserMenu {

    private final UserInputConsole userInputConsole;

    public StudentUserMenu(UserInputConsole userInputConsole) {
        this.userInputConsole = userInputConsole;
    }

    public void displayMenu() {
        boolean continueExecution = true;

        while (continueExecution) {
            System.out.println("Welcome to 'Online Course 401':)");
            System.out.println("0. Start");
            System.out.println("1. Exit");

            int choice = userInputConsole.getInputChoice();

            switch (choice) {
                case 0:
                    userInputConsole.inputRegistrationData();
                    break;
                case 1:
                    continueExecution = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }


}
