package application.domain.validator;

import application.domain.model.Author;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

public class CreateAuthorValidator {
    public static void validate(Author author) throws ValidationException {

        List<String> fields = new ArrayList<>();

        if (author.getName() == null)
            fields.add("name");
        if (author.getBirth_date() == null)
            fields.add("bith_date");
        if (author.getNationality() == null)
            fields.add("nationality");

            if (fields.size() > 0) {
                throw new ValidationException("Required fields were not provided...",
                        "Author validation: ".concat(fields.toString()).concat(" is required!"));
            }

    }
}
