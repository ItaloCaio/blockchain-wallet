package application.service;

import application.domain.model.Author;
import application.domain.validator.CreateArtworkValidator;
import application.domain.validator.CreateAuthorValidator;
import application.port.IAuthorService;
import infrastructure.repository.AuthorRepository;
import ui.exception.ResourceNotFoundException;

public class AuthorService implements IAuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public Author add(Author item) {
        try{
            CreateAuthorValidator.validate(item);
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }
        return authorRepository.save(item);
    }

    @Override
    public Iterable<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(Long id) {
        try{
            verifyIfAuthorExists(id);
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }
        return authorRepository.findOne(id);
    }

    @Override
    public Author update(Author item) {
        try{
            verifyIfAuthorExists(item.getId());
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }
        return authorRepository.save(item);
    }

    @Override
    public Author remove(Author item) {
        try{
            verifyIfAuthorExists(item.getId());
            authorRepository.delete(item.getId());
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }
        return item;
    }

    @Override
    public int count() {
        return 0;
    }
    private void verifyIfAuthorExists(Long id){
        if (authorRepository.findOne(id) == null)
            throw new ResourceNotFoundException("Author not found for ID: " + id);
    }

}
