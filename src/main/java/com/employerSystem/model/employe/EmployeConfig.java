package com.employerSystem.model.employe;

import java.time.Month;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(EmployeRepository repository) {
		return args -> {
			Employe Ahmed = new Employe(
					"Ahmed",
					"Ben-rjab",
					"Ahmed@gmail.com",
					LocalDate.of(1989, Month.JULY, 22),
					2100
					);
			Employe Mariam = new Employe(
					"Mariem",
					"tonsi",
					"tonsi@gmail.com",
					LocalDate.of(1992, Month.AUGUST, 05),
					1500
					);
			
			repository.saveAll(List.of(Ahmed, Mariam));
		};
	}
}
