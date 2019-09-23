package app.application.domain.validator;

import app.application.domain.exception.ValidationException;
import app.application.domain.model.Author;


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
        else{
            if ( author.getNationality() == "Brasil")
                if (author.getCpf() == null)
                    fields.add("cpf");
        }

            if (fields.size() > 0) {
                throw new ValidationException("Required fields were not provided..."+
                        "\nAuthor validation: ".concat(fields.toString()).concat(" is required!"));
            }

    }
}
