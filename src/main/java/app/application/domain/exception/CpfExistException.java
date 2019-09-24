package app.application.domain.exception;

public class CpfExistException extends Exception {

    public CpfExistException(){
        super("CPF already exist");
    }
}
