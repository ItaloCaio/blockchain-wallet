package app.ui.controller;

import app.ui.rest.controller.BlockchainController;
import app.ui.rest.util.BlockEnv;
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
        else{
//            //create genesis transaction, which sends 100 NoobCoin to walletA:
//                int aux = 0;
//
//                if (aux < 1){
//                    BlockchainController  blockchainController = new BlockchainController();
//                }
//                aux ++;
            return "views/wallet";
        }

    }
}
