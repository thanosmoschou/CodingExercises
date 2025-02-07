package com.thanos.secure_book_api_v1.controllers;

import com.thanos.secure_book_api_v1.model.User;
import com.thanos.secure_book_api_v1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {
    // Do not confuse it with CustomUserDetailsService. This UserService is for saving users to the db
    // while CustomUserDetailsService is for loading already registered users from the db to check for the
    // credentials. Maybe it was better to skip the UserService and provide the UserRepository straight away here
    // in the controller class. Keep this in mind for next projects...
    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return "User registered.";
    }
}
