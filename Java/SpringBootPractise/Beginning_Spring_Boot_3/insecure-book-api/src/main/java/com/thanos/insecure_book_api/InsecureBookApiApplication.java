/*
Author: Thanos Moschou
Description: Insecure book rest api, project based on Beginning Spring Boot 3 book
Dependencies: Spring Web, Spring Data JPA, MySQL Driver
You need to have MySQL configured on your pc.
 */

package com.thanos.insecure_book_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InsecureBookApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsecureBookApiApplication.class, args);
	}

}
