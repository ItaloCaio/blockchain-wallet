package app.application.domain.exception;

public class EmailExistException extends Exception {

    public EmailExistException(){
        super("Email already exist");
    }
}
