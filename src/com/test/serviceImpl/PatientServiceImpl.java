package com.test.serviceImpl;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.test.model.Patient;
import com.test.service.PatientService;
import com.test.util.CommonConstants;
import com.test.util.DBConnectionUtil;
import com.test.util.QueryUtil;

public class PatientServiceImpl implements PatientService {

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
			statement.executeUpdate(QueryUtil.dropPatientTable());
			// Create new patient table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.createPatientTable());

		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void addPatient(Patient patient) {
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			
			preparedStatement = connection
					.prepareStatement(QueryUtil.insertPatient());
			connection.setAutoCommit(false);
			
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, patient.getfName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, patient.getlName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, patient.getDOB());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, patient.getGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, patient.getPhoneNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, patient.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, patient.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, patient.getPassword());
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

	@Override
	public Patient getPatientByID(String patientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Patient> getPatient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient updatePatient(String employeeID, Patient employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePatient(String patientID) {
		// TODO Auto-generated method stub
		
	}

	public static boolean login(Patient patient) {
		
		boolean status = false;
		Connection con = null;
		PreparedStatement preparedStatement = null;
	
try {


con = DBConnectionUtil.getDBConnection();
    
	preparedStatement  = con
    .prepareStatement(QueryUtil.selectpatient());
    preparedStatement.setString(1, patient.getEmail());
    preparedStatement.setString(2, patient.getPassword());
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
