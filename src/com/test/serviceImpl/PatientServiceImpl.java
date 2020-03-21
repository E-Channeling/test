package com.test.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import com.test.model.Patient;
import com.test.service.PatientService;

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
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			// Create new patient table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	@Override
	public void addPatient(Patient patient) {
		// TODO Auto-generated method stub
		
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

}
