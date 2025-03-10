    package com.thanos.WebFluxDemo.repository;

    import com.thanos.WebFluxDemo.model.User;
    import org.springframework.data.repository.reactive.ReactiveCrudRepository;
    import org.springframework.stereotype.Repository;
    import reactor.core.publisher.Mono;

    // Dynamic Query Generation provided by Spring Data (The same happens also with JPA)

    @Repository
    public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
        Mono<User> findUserByName(String name);
        Mono<Void> deleteUserByName(String name);
    }
