package app.application.domain.exception;

public class CpfExistException extends RuntimeException {

    public CpfExistException(){
        super("CPF already exist");
    }
}
