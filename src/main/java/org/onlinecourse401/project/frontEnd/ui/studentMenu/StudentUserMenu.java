package org.onlinecourse401.project.frontEnd.ui.studentMenu;

import java.util.List;
import java.util.Scanner;

public class StudentUserMenu {
    private final List<StudentMenuCommand> commands;

    public StudentUserMenu(List<StudentMenuCommand> commands) {
        this.commands = commands;
    }

    public void startUserMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exitRequested = false;

        while (!exitRequested) {
            for (int i = 0; i < commands.size(); i++) {
                System.out.println(i + ". " + commands.get(i).getMenuName());
            }
            System.out.println("Make your choice: ");

            int userInput = Integer.parseInt(scanner.next());

            if (userInput < 0 || userInput >= commands.size()) {
                System.out.println("Invalid option, please try again.");
            }
            else {
                StudentMenuCommand command = commands.get(userInput);
                command.executeCommand();
                exitRequested = command.shouldExit();
            }


        }
    }
}
