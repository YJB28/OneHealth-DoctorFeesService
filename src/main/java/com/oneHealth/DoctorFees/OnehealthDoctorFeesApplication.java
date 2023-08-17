package com.oneHealth.DoctorFees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The main class to start the OneHealth Doctor Fees Services application.
 *
 * This class serves as the entry point for the Doctor Fees Service application.
 * It uses the SpringApplication class to bootstrap and launch the Spring Boot application.
 * 
 * Note: Make sure to import the required Spring Boot annotations.
 * 
 * @author Madhavi
 * @version 1.0
 */
@SpringBootApplication
@RestController
public class OnehealthDoctorFeesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnehealthDoctorFeesApplication.class, args);
	}
	
	@GetMapping
	public String Welcome() {
		
		return "Welcome From OneHealth Team (OneHealth-DoctorFeesService)!!!";
	}

}
