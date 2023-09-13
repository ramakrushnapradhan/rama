package com.icici.demo.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icici.demo.dao.EmployeeDao;
import com.icici.demo.dao.impl.DatabaseConnector;
import com.icici.demo.model.Employee;
import com.icici.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public String insertEmployee(Employee employee) {
		
		try(Connection connection = DatabaseConnector.getConnection()) {
			employeeDao.createUser(connection, employee.getEmpId(), employee.getEmpName());
		} catch (SQLException e) {
			e.printStackTrace();
			return "Failed to create Employee";
		}	
		return "User inserted successfully ::"+employee.toString();
	}


	public  List<Employee>  getAllEmployees() {
		List<Employee> employees= null;
		try(Connection connection = DatabaseConnector.getConnection()) {
			 employees=	employeeDao.readUsers(connection);
		} catch (SQLException e) {
			e.printStackTrace();
			return employees;
		}
		return employees;
	}


	@Override
	public String updateUser(String name, String empName) {
		try(Connection connection = DatabaseConnector.getConnection()) {
			return employeeDao.updateUser(connection,name,empName);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Operation failed or no rows were affected.";
		}
	}


	@Override
	public String deleteUser(String name) {
		try(Connection connection = DatabaseConnector.getConnection()) {
		  return employeeDao.deleteUser(connection,name);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Operation failed or no rows were affected.";
		}
	}

}