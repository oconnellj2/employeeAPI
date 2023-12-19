package com.oconnellj2.employeeAPI.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.oconnellj2.employeeAPI.entity.Employee;
import com.oconnellj2.employeeAPI.service.EmployeeService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private final EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.getEmployee(id));
	}

	@PostMapping
	public ResponseEntity<String> addEmployee(@RequestBody @Validated Employee employee) {
		String employeeId = employeeService.addEmployee(employee);
		return ResponseEntity.created(URI.create("/employees/" + employeeId)).body("Employee created successfully");
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody @Validated Employee employee) {
		Employee existingEmployee = employeeService.getEmployee(id);
		if (existingEmployee == null) {
			return ResponseEntity.notFound().build();
		}
		if (employee.getName() != null) {
			existingEmployee.setName(employee.getName());
		}
		if (employee.getRole() != null) {
			existingEmployee.setRole(employee.getRole());
		}
		employeeService.updateEmployee(existingEmployee);

		return ResponseEntity.ok("Employee updated successfully");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		if (employeeService.getEmployee(id) == null) {
			return ResponseEntity.notFound().build();
		}
		employeeService.deleteEmployee(id);

		return ResponseEntity.ok("Employee deleted successfully");
	}
}