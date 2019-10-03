package app.application.service;

import app.application.domain.exception.CpfExistException;
import app.application.domain.exception.EmailExistException;
import app.application.domain.model.Author;
import app.application.domain.validator.CreateAuthorValidator;
import app.application.domain.validator.DeleteAuthorValidator;
import app.application.port.IAuthorService;
import app.infrastructure.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import app.ui.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements IAuthorService {

    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public Author add(Author item) {
        try{
            CreateAuthorValidator.validate(item);
            if (item.getEmail() != null)
                verifyIfEmailExists(item.getEmail());
            if (item.getCpf() != null)
                verifyIfCpfExists(item.getCpf());
           return authorRepository.save(item);
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }
        return null;
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
    public void remove(Long id) {
        try{
            verifyIfAuthorExists(id);
            DeleteAuthorValidator.validate(authorRepository.findOne(id));
            authorRepository.delete(id);
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }


    }

    @Override
    public int count() {
        return 0;
    }
    private void verifyIfAuthorExists(Long id){
        if (authorRepository.findOne(id) == null)
            throw new ResourceNotFoundException("Author not found for ID: " + id);
    }

    private void verifyIfEmailExists(String email) throws EmailExistException {
        for (Author author: this.getAll()){
            if (author.getEmail() == email){
                throw new EmailExistException();
            }
        }

    }
    private void verifyIfCpfExists(String cpf) throws CpfExistException {
        for (Author author: this.getAll()){
            if (author.getCpf() == cpf){
                throw new CpfExistException();
            }
        }

    }

}
