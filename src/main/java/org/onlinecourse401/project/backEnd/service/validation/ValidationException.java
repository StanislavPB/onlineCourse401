package org.onlinecourse401.project.backEnd.service.validation;

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}
