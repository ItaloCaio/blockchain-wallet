package app.ui.rest.controller;

import app.application.domain.model.Author;
import app.application.port.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import app.ui.error.CustomErrorType;


@RestController
@RequestMapping("authors")
public class AuthorRestController {

    private final IAuthorService authorService;

    @Autowired
    public AuthorRestController(IAuthorService authorService){
        this.authorService = authorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable("id") long id) {

        Author author = authorService.getById(id);
        if (author == null) {
            return new ResponseEntity<>(new CustomErrorType("Author not found "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addAuthor(@RequestBody Author author) {

        return new ResponseEntity<>(authorService.add(author), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable long id) {
        authorService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable("id") long id, @RequestBody Author author) {
        System.out.println(author.getName());
        author.setId(id);
        authorService.update(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
