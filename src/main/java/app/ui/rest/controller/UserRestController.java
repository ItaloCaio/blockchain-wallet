package app.ui.rest.controller;


import app.application.domain.model.User;
import app.application.domain.model.block.Wallet;
import app.infrastructure.repository.UserRepository;
import app.ui.error.CustomErrorType;
import app.ui.exception.ResourceNotFoundException;
import app.ui.rest.util.BlockEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserRestController {

    private final UserRepository userRepository;

    @Autowired
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") long id, @AuthenticationPrincipal UserDetails userDetails) {
        verifyUserIfStudentExists(id);
        User user = userRepository.findOne(id);
        if (user == null) {
            return new ResponseEntity<>(new CustomErrorType("User not found "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/on")
    public ResponseEntity<?> getUserOn(@AuthenticationPrincipal UserDetails userDetails) {

        User user = userRepository.findByUsername(userDetails.getUsername());
       Wallet walletA = new Wallet();
        //create genesis transaction, which sends 100 NoobCoin to walletA:
        BlockEnv.initTransaction(walletA);
        BlockEnv.initBlock();

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
            System.out.println("usuario salvo" +user);

         user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        verifyUserIfStudentExists(id);
        userRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody User user) {
        verifyUserIfStudentExists(user.getId());
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyUserIfStudentExists(Long id){
        if (userRepository.findOne(id) == null)
            throw new ResourceNotFoundException("User not found for ID: " + id);
    }

}
