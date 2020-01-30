package com.example.myKitchenManager.security;

import com.example.myKitchenManager.entity.Users;
import com.example.myKitchenManager.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users users = userRepository.findByUserName(userName);
        if (users == null) {
            throw new UsernameNotFoundException(userName);
        }
        return new User(users.getUserName(), users.getPassword(), Collections.emptyList());
    }
}
