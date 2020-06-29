package com.example.registration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistrationAssignmentApplication {

	private static final Logger LOGGER = LogManager.getLogger(RegistrationAssignmentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RegistrationAssignmentApplication.class, args);

		LOGGER.info("Info level log message");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");
	}

}
