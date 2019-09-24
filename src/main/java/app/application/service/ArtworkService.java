package app.application.service;

import app.application.domain.model.Artwork;
import app.application.domain.validator.CreateArtworkValidator;
import app.application.port.IArtworkService;
import app.infrastructure.repository.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import app.ui.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ArtworkService implements IArtworkService {
    private final ArtworkRepository artworkRepository;

    @Autowired
    public ArtworkService(ArtworkRepository artworkRepository){
        this.artworkRepository = artworkRepository;
    }


    @Override
    public Artwork add(Artwork item) {
        try{
            CreateArtworkValidator.validate(item);
            return artworkRepository.save(item);
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }
        return null;
    }

    @Override
    public Iterable<Artwork> getAll() {
        return artworkRepository.findAll();
    }

    @Override
    public Artwork getById(Long id) {
        try{
            verifyIfArtworkExists(id);
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }

        return artworkRepository.findOne(id);
    }

    @Override
    public Artwork update(Artwork item) {

        try{
            verifyIfArtworkExists(item.getId());
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }

        return artworkRepository.save(item);
    }

    @Override
    public void remove(Long id) {
        try{
            verifyIfArtworkExists(id);
            artworkRepository.delete(id);
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }

    }

    @Override
    public int count() {
        return 0;
    }

    private void verifyIfArtworkExists(Long id){
        if (artworkRepository.findOne(id) == null)
            throw new ResourceNotFoundException("Artwork not found for ID: " + id);
    }
}


