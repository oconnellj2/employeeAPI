package com.oconnellj2.employeeAPI.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oconnellj2.employeeAPI.entity.Employee;
import com.oconnellj2.employeeAPI.service.EmployeeService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<Employee>> fetchAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	// TODO: Implement GET /employees/{id} (get single record by id)
	// TODO: Implement POST /employees (create)
	// TODO: Implement PUT /employees/{id} (replace/update)
	// TODO: Implement DELETE /employees/{id}

}
