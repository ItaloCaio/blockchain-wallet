package app.application.domain.exception;

public class EmailExistException extends RuntimeException {

    public EmailExistException(){
        super("Email already exist");
    }
}
