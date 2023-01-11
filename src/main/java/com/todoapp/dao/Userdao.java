package com.todoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.todoapp.model.User;
import com.todoapp.utils.JDbcUtil;

public class Userdao {

	
	
	public int registeremployee(User employee) {
		
		 String INSERT_USERS_SQL = "INSERT INTO users" +
		            "  (first_name, last_name, username, password) VALUES " +
		            " (?, ?, ?, ?);";

		        int result = 0;
		        try (Connection connection = JDbcUtil.getconnection();
		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
		            preparedStatement.setString(1, employee.getFirstname());
		            preparedStatement.setString(2, employee.getLastname());
		            preparedStatement.setString(3, employee.getUsername());
		            preparedStatement.setString(4, employee.getPassword());

		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            result = preparedStatement.executeUpdate();
		            System.out.println(result);

		        } catch (SQLException e) {
		            // process sql exception
		            JDbcUtil.printSQLException(e);
		        }
		        return result;
		    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
