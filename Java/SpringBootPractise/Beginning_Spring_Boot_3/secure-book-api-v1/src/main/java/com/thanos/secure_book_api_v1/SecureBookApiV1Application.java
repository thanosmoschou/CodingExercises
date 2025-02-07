package com.thanos.secure_book_api_v1;

import com.thanos.secure_book_api_v1.repository.UserRepository;
import com.thanos.secure_book_api_v1.services.UserService;
import com.thanos.secure_book_api_v1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecureBookApiV1Application implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	// I do not provide UserService because it has a method that need a role and
	// I do not have users with roles yet...
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecureBookApiV1Application.class, args);
	}

	// Use CommandLineRunner to execute the run method right after application starts,
	// and then save some pre-defined users to our db
	@Override
	public void run(String... args) throws Exception {
		User adminUser = new User("admin", passwordEncoder.encode("0000"), "ADMIN,USER");
		userRepository.save(adminUser);
	}
}
