package com.thanos.secure_book_api_v1.controllers;

import com.thanos.secure_book_api_v1.model.User;
import com.thanos.secure_book_api_v1.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {
    // Do not confuse it with CustomUserDetailsService. This UserService is for saving users to the db
    // while CustomUserDetailsService is for loading already registered users from the db (in User format
    // from our model), and convert
    // them to a UserDetails object for Spring security in order to check for the
    // credentials. Maybe it was better to skip the UserService and provide the UserRepository straight away here
    // in the controller class. Keep this in mind for next projects...
    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String registerUser(@RequestBody User user) {
        logger.info("Register user details {}", user.toString());
        userService.registerUser(user);
        return "User registered.";
    }
}
