package com.oconnellj2.employeeAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oconnellj2.employeeAPI.entity.Employee;
import com.oconnellj2.employeeAPI.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	private EmployeeRepository repo;

	public List<Employee> getAllEmployees() {
		// TODO: implement exception handling and business logic(if/when necessary).
		return repo.findAll();
	}
}
