package com.icici.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icici.demo.model.Employee;
import com.icici.demo.service.EmployeeService;

@RestController
public class BaseController {

	@Autowired
	EmployeeService empService;

	@PostMapping("create")
	public String create(@RequestBody Employee employee) {
		return empService.insertEmployee(employee);
	}

	@GetMapping("read")
	public List<Employee> read() {
		return empService.getAllEmployees();
	}

	@PutMapping("update")
	public String update(@RequestBody Employee employee) {
		return empService.updateUser(employee.getEmpId(), employee.getEmpName());
	}
	@DeleteMapping("/delete/{username}")
	public String deleteUser(@PathVariable String username) {
		return empService.deleteUser(username);
	}
}
