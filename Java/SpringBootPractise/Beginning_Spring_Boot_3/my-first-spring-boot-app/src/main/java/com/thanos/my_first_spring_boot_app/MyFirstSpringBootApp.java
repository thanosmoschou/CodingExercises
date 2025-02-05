package com.thanos.my_first_spring_boot_app;

import com.thanos.my_first_spring_boot_app.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MyFirstSpringBootApp implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(MyFirstSpringBootApp.class);
	private final AppConfig ac;

	public MyFirstSpringBootApp(AppConfig a) {
		ac = a;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringBootApp.class, args);
	}

	@Override
	public void run(String... args) {
		logger.error("Error thanos");
		logger.debug("Debug thanos");
		logger.warn("Warn thanos");
		logger.info("Info thanos");

		ac.printValues();
	}

}
