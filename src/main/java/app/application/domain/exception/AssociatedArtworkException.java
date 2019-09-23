package app.application.domain.exception;

public class AssociatedArtworkException extends RuntimeException{
    public AssociatedArtworkException(){
        super("Author has artworks associateds");
    }
}
