package com.test.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.model.Booking;
import com.test.service.iBookService;
import com.test.util.CommonConstants;
import com.test.util.DBConnectionUtil;
import com.test.util.QueryUtil;

public class BookServiceImpl implements iBookService {
	
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;
	
	private PreparedStatement preparedStatement1;
	


	static{
		//create table or drop if exist
		createBookingTable();
		
	}

	public static void createBookingTable() {
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.dropBookingTable());
			// Create new patient table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.createBookingTable());

		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	
	public void addBooking(Booking booking) {
		try {
			connection = DBConnectionUtil.getDBConnection();
		/*
		 * Query is available in EmployeeQuery.xml file and use
		 * insert_employee key to extract value of it
		 */
		
		preparedStatement = connection
				.prepareStatement(QueryUtil.insertbooking());
		connection.setAutoCommit(false);
		
		System.out.println(booking.getPatientId());
		System.out.println(booking.getDoctorId());
		preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, booking.getEmail());
		preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, booking.getDoctorName());
		preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, booking.getBookingDate());
		preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, booking.getCategory());
		preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, booking.getHospital());
		preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, booking.getDescription());
		preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, booking.getPatientId());
		System.out.println("methanata awa");
		preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, booking.getDoctorId());
		
		
		// Add employee
		preparedStatement.execute();
		connection.commit();
		System.out.println("palaweni eaka iwarai");
	
		System.out.println("data waduna");

	} catch (SQLException | ClassNotFoundException e) {
		log.log(Level.SEVERE, e.getMessage());
	} finally {
		/*
		 * Close prepared statement and database connectivity at the end of
		 * transaction
		 */
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	}

}
