package com.example.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)) {
            return new User("user", "$2a$10$Dowqj.OXxvIdY8Zomw6a1Oskf.uTUzjtUJoToDLoQ0A/Wy5cZQn9O", Collections.emptyList()); // password: password
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
