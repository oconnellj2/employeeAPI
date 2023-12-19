package com.oconnellj2.employeeAPI.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oconnellj2.employeeAPI.entity.Employee;
import com.oconnellj2.employeeAPI.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class Database {
	@Bean
	CommandLineRunner initDataBase(EmployeeRepository repo) {
		return args -> {
			log.info("Preloading " + repo.save(new Employee("Bilbo Baggins", "burglar")));
			log.info("Preloading " + repo.save(new Employee("Frodo Baggins", "ring bearer")));
			log.info("Preloading " + repo.save(new Employee("Samwise Gamgee", "side kick")));
			log.info("Preloading " + repo.save(new Employee("Pippin Took", "fool")));
			log.info("Preloading " + repo.save(new Employee("Merry Brandybuck", "mischievous")));
		};
	}
}
