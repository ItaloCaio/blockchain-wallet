package application.service;

import application.domain.model.Artwork;
import application.domain.validator.CreateArtworkValidator;
import application.port.IArtworkService;
import infrastructure.repository.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import ui.exception.ResourceNotFoundException;

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
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }
        return artworkRepository.save(item);
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
    public Artwork remove(Artwork item) {

        try{
            verifyIfArtworkExists(item.getId());
            artworkRepository.delete(item.getId());
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

    private void verifyIfArtworkExists(Long id){
        if (artworkRepository.findOne(id) == null)
            throw new ResourceNotFoundException("Artwork not found for ID: " + id);
    }
}


