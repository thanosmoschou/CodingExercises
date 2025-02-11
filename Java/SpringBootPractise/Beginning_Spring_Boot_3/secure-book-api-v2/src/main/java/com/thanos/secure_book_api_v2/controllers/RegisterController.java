package com.thanos.secure_book_api_v2.controllers;

import com.thanos.secure_book_api_v2.model.User;
import com.thanos.secure_book_api_v2.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        logger.info("Register user details {}", user.toString());
        userRepository.save(user);
        return "User registered.";
    }
}
