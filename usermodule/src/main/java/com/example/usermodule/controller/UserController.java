package com.example.usermodule.controller;

import com.example.usermodule.model.User;
import com.example.usermodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("getAll")
    public List<User> getAllUsers(){
        return userService.fetchAllUser();
    }
}
