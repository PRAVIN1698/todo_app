package com.todoapp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.todoapp.model.login;
import com.todoapp.utils.JDbcUtil;

public class logindao {

	
	public boolean validate(login LoginBean) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = JDbcUtil.getconnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from users where username = ? and password = ?")) {
            preparedStatement.setString(1, LoginBean.getUsername());
            preparedStatement.setString(2, LoginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            System.out.print(status);

        } catch (SQLException e) {
            // process sql exception
            JDbcUtil.printSQLException(e);
        }
        return status;
    }
	
	
	
	
	  
	
	
	
	
	
	
	
	
	
	
	
	
	
}
