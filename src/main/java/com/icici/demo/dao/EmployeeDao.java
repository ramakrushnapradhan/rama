package com.icici.demo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.icici.demo.model.Employee;

public interface EmployeeDao {
	public  void createUser(Connection connection, String name, String empName) throws SQLException ;
	public  List<Employee> readUsers(Connection connection) throws SQLException ;
	public String updateUser(Connection connection,String name, String empName) throws SQLException;
	public String deleteUser(Connection connection, String name) throws SQLException;
}