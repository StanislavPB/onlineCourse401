package org.onlinecourse401.project.backEnd.service.validation;

import org.onlinecourse401.project.backEnd.dto.StudentDto;
import org.onlinecourse401.project.frontEnd.util.UserInput;

import java.util.ArrayList;
import java.util.List;

//2 метода
//-переделать
public class ValidationRequest {


    public boolean checkEmail(StudentDto studentDto){
        List<String> errors = new ArrayList<>();
        String studentEmail = studentDto.getEmail();
        if (studentEmail.isBlank()){
            errors.add("Email must be not null \n");
        }
        if ((studentEmail.length() < 5) || (studentEmail.length() > 30)) {
            errors.add("Email length must be between 5 and 29 letters \n");
        }
        if(!studentEmail.contains("@")){
            errors.add("Email must contain '@'.\n");
        }
        if(!studentEmail.contains(".")){
            errors.add("Email must contain '.'.\n");
        }
        if (!errors.isEmpty()) throw new ValidationException(errors.toString());

        return true;

    }

    public boolean checkPassword(StudentDto studentDto){
        List<String> errors = new ArrayList<>();
        String studentPassword = studentDto.getPassword();
        if (studentPassword.isBlank()){
            errors.add("Password must be not null \n");
        }
        if ((studentPassword.length() < 7) || (studentPassword.length() > 11)) {
            errors.add("Password length must be between 7 and 10 letters \n");
        }
        if (studentPassword.contains(" ") || studentPassword.contains(":") || studentPassword.contains("'")) {
            errors.add("Password contain invalid characters.\n");
        }
        if (!errors.isEmpty()) throw new ValidationException(errors.toString());

        return true;
    }
    public int inputIntegerWithValidation(UserInput ui, String prompt) {
        while (true) {
            try {
                return Integer.parseInt(ui.inputText(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }


}
