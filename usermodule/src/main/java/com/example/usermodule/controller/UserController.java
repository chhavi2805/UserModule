package com.example.usermodule.controller;

import com.example.usermodule.model.User;
import com.example.usermodule.service.UserService;
import jakarta.validation.Valid;
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

    @GetMapping("getAll")
    public List<User> getAllUsers(){
        return userService.fetchAllUser();
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addNewUser(@Valid @RequestBody User user){
        System.out.println("Adding new user" + user.toString() + "---------------------->");
        User userResponse = null;
        try {
            userResponse = userService.addNewUser(user);
            return ResponseEntity.ok(userResponse);
        } catch (Exception e) {
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
