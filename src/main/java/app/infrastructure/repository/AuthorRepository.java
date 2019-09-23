package app.infrastructure.repository;
import org.springframework.data.repository.CrudRepository;
import app.application.domain.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
}
