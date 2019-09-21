package ui.controller;

import application.domain.model.Author;
import infrastructure.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ui.error.CustomErrorType;
import ui.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllAuthors() {
        return new ResponseEntity<>(authorRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable("id") long id) {
        verifyIfAuthorExists(id);
        Author author = authorRepository.findOne(id);
        if (author == null) {
            return new ResponseEntity<>(new CustomErrorType("Author not found "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addAuthor(@RequestBody Author author) {

        return new ResponseEntity<>(authorRepository.save(author), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable long id) {
        verifyIfAuthorExists(id);
        authorRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateAuthor(@RequestBody Author author) {
        verifyIfAuthorExists(author.getId());
        authorRepository.save(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    private void verifyIfAuthorExists(Long id){
        if (authorRepository.findOne(id) == null)
            throw new ResourceNotFoundException("Author not found for ID: " + id);
    }
}
