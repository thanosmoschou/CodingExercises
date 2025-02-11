package com.thanos.secure_book_api_v2;

import com.thanos.secure_book_api_v2.model.User;
import com.thanos.secure_book_api_v2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecureBookApiV2Application implements CommandLineRunner {
	private PasswordEncoder passwordEncoder;
	private UserRepository userRepository;

	@Autowired // You do not need @Autowired in Constructor injection
	public SecureBookApiV2Application(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(SecureBookApiV2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("admin", passwordEncoder.encode("0000"), "ADMIN");
		userRepository.save(user);
	}
}
