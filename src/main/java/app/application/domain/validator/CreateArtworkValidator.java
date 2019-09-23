package app.application.domain.validator;

import app.application.domain.exception.ValidationException;
import app.application.domain.model.Artwork;

import java.util.ArrayList;
import java.util.List;

public class CreateArtworkValidator {

    public static void validate(Artwork artwork) throws ValidationException {

        List<String> fields = new ArrayList<>();

        if(artwork.getName() == null)
            fields.add("name");
        if (artwork.getDescription() == null)
            fields.add("description");
        if (artwork.getPublication_date() == null && artwork.getExhibition_date() == null)
            fields.add("dates");

        if (fields.size() > 0) {
            throw new ValidationException("Required fields were not provided..." +
                    "\nArtwork validation: ".concat(fields.toString()).concat(" is required!"));
        }

    }
}
