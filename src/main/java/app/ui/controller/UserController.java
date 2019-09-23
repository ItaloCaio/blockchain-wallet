package app.ui.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String form() {
        return "views/register";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null)
            return "views/signin";
        else
            return "views/authors";
    }
}
