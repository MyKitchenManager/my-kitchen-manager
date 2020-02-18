package com.example.myKitchenManager.controller;

import com.example.myKitchenManager.repository.entity.Users;
import com.example.myKitchenManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/")
    @ResponseBody
    public Users getUserNameFromToken(UsernamePasswordAuthenticationToken authentication) {
        return userRepository.findByUserName(authentication.getName());
    }
}
