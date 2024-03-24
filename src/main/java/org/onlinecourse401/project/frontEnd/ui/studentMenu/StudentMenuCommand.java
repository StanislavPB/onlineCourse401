package org.onlinecourse401.project.frontEnd.ui.studentMenu;

public interface StudentMenuCommand {
    void executeCommand();

    String getMenuName();
    boolean shouldExit();
}
