package com.todoapp.utils;
import java.sql.*;
import java.time.LocalDate;


public class JDbcUtil {

	
	
	
	private static String jbdc="jdbc:mysql://localhost:3306/employee";
	
	private static String jdbcusername="root";
	
	private static String jdbcpassword="pravin@1234";
	
	
	public static Connection getconnection() {
		
		Connection connection=null;
		
		
		try{Class.forName("com.mysql.cj.jdbc.Driver"); 
			connection =DriverManager.getConnection(jbdc,jdbcusername,jdbcpassword);	
				
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return connection;
	}
	
	
	 public static void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	 
	 
	 
	 public static Date getSQLDate(LocalDate date) {
	        return java.sql.Date.valueOf(date);
	    }

	    public static LocalDate getUtilDate(Date sqlDate) {
	        return sqlDate.toLocalDate();
	    }
	 	
	
}
