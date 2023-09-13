package com.icici.demo.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;

public class DatabaseConnector {

//    @Value("${url}")
	private static String url="jdbc:mysql://localhost:3305/granite";
//	@Value("${userName}")
	private static String username="root";
//	@Value("${password}")
	private static String password="0000";
	
	 // Define a getConnection method with default values
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

//    // Overloaded method to allow custom connection details
//    public static Connection getConnection(String url, String username, String password) throws SQLException {
//        return DriverManager.getConnection(url, username, password);
//    }
	
}
