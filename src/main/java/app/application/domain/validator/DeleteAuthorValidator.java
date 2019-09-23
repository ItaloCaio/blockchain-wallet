package app.application.domain.validator;

import app.application.domain.exception.AssociatedArtworkException;
import app.application.domain.model.Author;

public class DeleteAuthorValidator {
    public static void validate(Author item){
        if (item.getArtworks().size() > 0)
            new AssociatedArtworkException();
    }
}
