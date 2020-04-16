package com.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil extends CommonUtil {
	
	private static Connection connection;

	// This works according to singleton pattern
	private DBConnectionUtil() {
	}

	/**
	 * Create Database connection for the given URL, Username and Password
	 * 
	 * @return Connection this returns SQL connection for MySql Database
	 * 
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name
	 * @throws SQLException
	 *             - An exception that provides information on a database access
	 *             error or other errors
	 */
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		/*
		 * This create new connection objects when connection is closed or it is
		 * null
		 */
		Connection con = null;
		 String url = "jdbc:mysql://127.0.0.1:3306/TESTING"; //MySQL URL followed by the database name
		 String username = "chathura123"; //MySQL username
		 String  password = "Cha0703091504*"; //MySQL password
		 
		 try 
		 {
			 try 
			 {
				Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
			 } 
			 catch (ClassNotFoundException e)
			 {
				e.printStackTrace();
			 }
			 
			 con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
			 System.out.println("Printing connection object "+con);
		 } 
		 catch (Exception e) 
		 {
			e.printStackTrace();
		 }
		 return con; 
		 }
	}


