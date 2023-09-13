package com.icici.demo.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.icici.demo.dao.EmployeeDao;
import com.icici.demo.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Override
	public  void createUser(Connection connection, String name, String empName) throws SQLException {
        String insertQuery = "INSERT INTO employee (empId, empName) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, empName);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User inserted successfully!");
            }
        }
    }
	
   @Override
    public List<Employee> readUsers(Connection connection) throws SQLException {
        String selectQuery = "SELECT * FROM employee";
        java.sql.Statement statement = connection.createStatement();
        List<Employee> employees= new ArrayList<Employee>();
        try (ResultSet resultSet = statement.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                String id = resultSet.getString("empId");
                String name = resultSet.getString("empName");
                Employee emp = new Employee();
                emp.setEmpId(id);
                emp.setEmpName(name);
                employees.add(emp);
            }
        }
		return employees;
    }
   @Override
   public String updateUser(Connection connection,String name, String empName) throws SQLException {
	   int rowsAffected = 0;
       try {
           String updateQuery = "UPDATE employee SET empName = ? WHERE empId = ?";
           try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
               preparedStatement.setString(1, empName);
               preparedStatement.setString(2, name);
               rowsAffected = preparedStatement.executeUpdate();
                
           }
       } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("Operation failed or no rows were affected.");
       }
       return rowsAffected == 1 ? "Update was successful.":"Operation failed or no rows were affected.";
       
   }
   @Override
   public String deleteUser(Connection connection,String name) {
	   int rowsAffected = 0;
       try{
           String deleteQuery = "DELETE FROM employee WHERE empId = ?";
           try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
               preparedStatement.setString(1, name);
               rowsAffected =   preparedStatement.executeUpdate();
           }
       } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("Operation failed or no rows were affected.");
       }
       return rowsAffected == 1 ? "Deletion was successful.":"Operation failed or no rows were affected.";
   }
}