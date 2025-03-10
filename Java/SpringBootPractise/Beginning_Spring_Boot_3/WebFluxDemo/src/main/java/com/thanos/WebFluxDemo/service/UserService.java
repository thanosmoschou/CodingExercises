package com.thanos.WebFluxDemo.service;

import com.thanos.WebFluxDemo.model.User;
import com.thanos.WebFluxDemo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// Simple CRUD service

@Service
public class UserService {
    private UserRepository userRepository;

    // private Logger logger = LoggerFactory.getLogger(UserService.class);

    // Constructor injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> addUser(User user) {
        // logger.info("Add user: {}", user);
        // logger.info("Is New? {}", user.isNew());

        // The logic is slightly different from JPA. In JPA we use save method
        // in both insert and update situations. JPA decides if
        // it has to insert or update the entry in the db.
        // Here in order to avoid wrong insert or update actions,
        // we use isNewEntry attribute to tell R2DBC that this entry is new
        // or old. If this attribute is set to true, then the entry is new, so
        // an insert will happen, otherwise is set to false, so an update happens.
        // So we check if the user exists already and if not then we set
        // the isNewEntry to true so an insert will occur.
        // In update method we still check if the user exists and if
        // yes then we set isNewEntry to false so an update will occur
        // when calling save method.
        return userRepository.findById(user.getId()) // flatMap gives a single Mono object. We use this to avoid nested Mono objects
                .flatMap(existingUser -> Mono.error(new DuplicateKeyException("User ID already exists!")))
                .switchIfEmpty(Mono.defer(() -> {
                    user.setNew(true); // New entry for R2DBC
                    return userRepository.save(user);
                }))
                .cast(User.class);
    }

    public Mono<User> updateUser(User user) {
        // logger.info("User before update: {}", user);

        return userRepository.findById(user.getId())
                .flatMap(existingUser -> {
                    user.setNew(false); // False so R2DBC handles this as an update
                    return userRepository.save(user);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("User not found!")));
    }

    public Mono<Void> deleteUser(String name) {
        return userRepository.deleteUserByName(name);
    }

    // Flux contains 0 to N elements so it is a stream of data.
    public Flux<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Mono contains 0 or 1 element
    public Mono<User> findUserByName(String aName) {
        return userRepository.findUserByName(aName);
    }
}
