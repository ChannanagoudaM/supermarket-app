package com.eidiko.supermarket_action_service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupermarketActionServiceApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		// Get the SonarQube token from the .env file
		String sonarToken = dotenv.get("SONAR_TOKEN");

		if (sonarToken != null) {
			// Set the SonarQube token as a system property
			System.setProperty("sonar.token", sonarToken);
		}
		SpringApplication.run(SupermarketActionServiceApplication.class, args);
	}
}
