package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.myKitchenManager.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository usersRepository;

    //Encrypt the password before saving to the DB to improve security
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Users users) {
        //Check if the username is already used
        if (usersRepository.findByUserName(users.getUserName()) != null) {
            return ResponseEntity.badRequest().body("Username occupied");
        }
        //if username is available, go ahead and create user
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        usersRepository.save(users);
        return ResponseEntity.ok("User successfully created");
    }

}
