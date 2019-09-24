package app.application.domain.exception;

public class AssociatedArtworkException extends Exception{
    public AssociatedArtworkException(){
        super("Author has artworks associateds");
    }
}
