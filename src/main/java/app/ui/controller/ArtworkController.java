package app.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtworkController {

    @RequestMapping(value = "/obras", method = RequestMethod.GET)
    public String artworks() {
        return "views/artworks";
    }

    @RequestMapping(value = "/obra/{codigo}", method = RequestMethod.GET)
    public String artworkById(@PathVariable("codigo") long codigo) {
        return "views/manageArtwork";
    }

    @RequestMapping(value = "/cadastrar-obra", method = RequestMethod.GET)
    public String artworkRegister() {
        return "views/registerArtwork";
    }
}
