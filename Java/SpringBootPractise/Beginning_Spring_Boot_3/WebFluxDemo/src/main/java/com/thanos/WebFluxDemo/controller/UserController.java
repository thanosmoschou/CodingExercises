package com.thanos.WebFluxDemo.controller;

import com.thanos.WebFluxDemo.model.User;
import com.thanos.WebFluxDemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// Here we implement WebFlux using annotations like SpringMVC. We could also have used Functional Endpoints

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // I could not have used ResponseEntity and use @ResponseStatus instead
    @PostMapping("/add")
    public Mono<User> addUser(@RequestBody User user) {
        // thenReturn returns a Mono<ResponseEntity>. We don't use it here
        // Mono.just also returns a Mono object
        return userService.addUser(user);
    }

    @PutMapping("/update")
    public Mono<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{name}")
    public Mono<ResponseEntity<String>> deleteUser(@PathVariable String name) {
        return userService.deleteUser(name)
                .thenReturn(ResponseEntity.ok("User Deleted!"))
                .onErrorResume(e -> Mono.just(ResponseEntity.status(500).body(e.getMessage())));
    }

    @GetMapping
    public Flux<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{name}")
    public Mono<User> findUserByName(@PathVariable String name) {
        return userService.findUserByName(name);
    }
}
