package com.icici.demo.service;

import java.util.List;

import com.icici.demo.model.Employee;

public interface EmployeeService {
	String insertEmployee(Employee emp);
	List<Employee> getAllEmployees();
	String updateUser(String name, String empName);
	String deleteUser(String name);
}