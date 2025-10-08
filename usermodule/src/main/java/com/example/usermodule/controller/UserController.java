package com.example.usermodule.controller;

import com.example.usermodule.model.User;
import com.example.usermodule.service.UserService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @GetMapping("getAll")
    public List<User> getAllUsers(){
        logger.info("Getting all users---------------------->");
        System.out.println("Getting all users---------------------->");
        return userService.fetchAllUser();
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addNewUser(@Valid @RequestBody User user){
        logger.info("Adding new user" + user.toString() + "---------------------->");
        User userResponse = null;
        try {
            userResponse = userService.addNewUser(user);
            return ResponseEntity.ok(userResponse);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(409).body("User could not be added");
        }

    }

    @PostMapping("/findByContact")
    public Optional<User> findByContact(@Valid @RequestBody String contact){
        return userService.findByContact(contact);
    }
    @GetMapping("/findByContact/{contact}")
    public Optional<User> findByContactParam(@PathVariable String contact){
        return userService.findByContact(contact);
    }

    @PostMapping("/findByEmail")
    public ResponseEntity<?> findByEmail(@Valid @RequestBody String email){
        Optional<User> userFound = userService.findByEmail(email);
        if(userFound.isPresent())
            return ResponseEntity.ok(userFound.get());
        else
            return ResponseEntity.status(404).body("User not found");
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<?> findByEmailPathVariable(@PathVariable String email){
        Optional<User> userFound = userService.findByEmail(email);
        if(userFound.isPresent())
            return ResponseEntity.ok(userFound.get());
        else
            return ResponseEntity.status(404).body("User not found");
    }
    @GetMapping("/findByEmailParam")
    public ResponseEntity<?> findByEmailParams(@Param("email") String email){
        Optional<User> userFound = userService.findByEmail(email);
        if(userFound.isPresent())
            return ResponseEntity.ok(userFound.get());
        else
            return ResponseEntity.status(404).body("User not found");
    }
}
