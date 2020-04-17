package com.test.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.model.Doctor;
import com.test.service.iDoctorService;
import com.test.util.CommonConstants;
import com.test.util.DBConnectionUtil;
import com.test.util.QueryUtil;

public class DoctorServiceImpl implements iDoctorService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createPatientTable();
	}
	
	private PreparedStatement preparedStatement;
	
	public static void createPatientTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.dropDoctorTable());
			// Create new patient table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.createDoctorTable());

		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	public void addDoctor(Doctor doctor) {
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			
			preparedStatement = connection
					.prepareStatement(QueryUtil.insertDoctor());
			connection.setAutoCommit(false);
			
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, doctor.getDoctorRegID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, doctor.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, doctor.getSpecialized());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, doctor.getGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, doctor.getContactNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, doctor.getHospital());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, doctor.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, doctor.getPassword());
			// Add employee
			preparedStatement.execute();
			connection.commit();
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

public static boolean login(Doctor doctor) {

		boolean status = false;
		Connection con = null;
		PreparedStatement preparedStatement = null;
	
try {


con = DBConnectionUtil.getDBConnection();
    
	preparedStatement  = con
    .prepareStatement(QueryUtil.selectDoctor());
    preparedStatement.setString(1, doctor.getEmail());
    preparedStatement.setString(2, doctor.getPassword());
    System.out.println("methanata awa");
    System.out.println(preparedStatement);
    ResultSet rs = preparedStatement.executeQuery();
    status = rs.next();
    System.out.println(status);


} catch (SQLException | ClassNotFoundException e) {
    // process sql exception
    System.out.println(e);
}

return status;

}


		



}
