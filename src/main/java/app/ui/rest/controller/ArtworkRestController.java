package app.ui.rest.controller;

import app.application.domain.model.Artwork;
import app.application.port.IArtworkService;
import app.application.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import app.ui.error.CustomErrorType;

@RestController
@RequestMapping("artworks")
public class ArtworkRestController {

    private final IArtworkService artworkService;

    @Autowired
    public ArtworkRestController(ArtworkService artworkService){
        this.artworkService = artworkService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllArtworks() {
        return new ResponseEntity<>(artworkService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getArtworkById(@PathVariable("id") long id) {
        Artwork artwork = artworkService.getById(id);
        if (artwork == null) {
            return new ResponseEntity<>(new CustomErrorType("Artwork not found "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(artwork, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addArtwork(@RequestBody Artwork artwork) {

        return new ResponseEntity<>(artworkService.add(artwork), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteArtwork(@PathVariable long id, @RequestBody Artwork artwork ) {

        artworkService.remove(artwork);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateArtwork(@RequestBody Artwork artwork) {
        artworkService.update(artwork);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
