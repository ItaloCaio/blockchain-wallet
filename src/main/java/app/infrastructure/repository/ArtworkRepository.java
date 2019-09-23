package app.infrastructure.repository;

import app.application.domain.model.Artwork;
import org.springframework.data.repository.CrudRepository;

public interface ArtworkRepository extends CrudRepository<Artwork, Long> {
}
