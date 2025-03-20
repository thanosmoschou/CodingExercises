package com.thanos.demo1.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class HelloController {
    // If you do not add a control method for an endpoint, a whitelabel error will appear.

    @GetMapping // GET Request to localhost:8080
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/hello2")
    public String sayHello2() {
        return "Hello2";
    }

    @GetMapping("/hello_user/{username}")
    public String helloUser(@PathVariable String username) {
        // With PathVariable you get the variable from the path
        return "Hello " + username;
    }

    @GetMapping("/hello_user")
    public String helloUser2(@RequestParam String username) {
        // In your request you can pass parameters using ?
        // For example: localhost:8080/hello_user?username=thanos
        return "Hello " + username;
    }
}
