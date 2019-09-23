package app.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {

    @RequestMapping(value = "/autores", method = RequestMethod.GET)
    public String authors() {
        return "views/authors";
    }

    @RequestMapping(value = "/autores/{codigo}", method = RequestMethod.GET)
    public String authorById(@PathVariable("codigo") long codigo) {
        return "views/authors";//author-manage
    }
}
