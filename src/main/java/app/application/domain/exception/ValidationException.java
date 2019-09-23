package app.application.domain.exception;

public class ValidationException extends Exception {

    public ValidationException(String message){
        super(message);
    }
}
