package infrastructure.repository;
import org.springframework.data.repository.CrudRepository;
import application.domain.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
}
