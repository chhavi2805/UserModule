package com.example.usermodule.service;

import com.example.usermodule.model.User;
import com.example.usermodule.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public List<User> fetchAllUser(){
        List<User> users = userRepo.findAll();
        return users;
    }
    public User addNewUser(User user) throws Exception{
        return userRepo.save(user);
    }
    public Optional<User> findByContact(String contact){
        return userRepo.findByContact(contact);
    }
    public Optional<User> findByEmail(String email){
        return userRepo.findByEmail(email);
    }

}
