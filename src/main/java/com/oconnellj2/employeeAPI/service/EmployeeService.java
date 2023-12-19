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
		return repo.findAll();
	}

	public Employee getEmployee(Long id) {
		return repo.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	public String addEmployee(Employee employee) {
		return String.valueOf(repo.save(new Employee(employee.getName(), employee.getRole())).getId());
	}

	public void updateEmployee(Employee employee) {
		repo.save(employee);
	}

	public void deleteEmployee(Long id) {
		repo.deleteById(id);
	}
}
