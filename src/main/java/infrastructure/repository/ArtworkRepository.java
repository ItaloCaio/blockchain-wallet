package infrastructure.repository;

import application.domain.model.Artwork;
import org.springframework.data.repository.CrudRepository;

public interface ArtworkRepository extends CrudRepository<Artwork, Long> {
}
