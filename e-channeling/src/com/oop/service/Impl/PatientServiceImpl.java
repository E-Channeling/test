package com.oop.service.Impl;


import java.io.IOException;
import java.io.InputStream;
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

import com.oop.model.Patient;
import com.oop.service.PatientService;
import com.oop.util.CommonConstants;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;


public class PatientServiceImpl implements PatientService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		//createPatientTable();
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
	public void addPatient(Patient patient, InputStream inputStream) {
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_PATIENT));
			connection.setAutoCommit(false);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, patient.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, patient.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, patient.getDob());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, patient.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, patient.getContact());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, patient.getGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, patient.getEmail());
			preparedStatement.setBlob(CommonConstants.COLUMN_INDEX_EIGHT, inputStream);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINIE, patient.getUser_id());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, patient.getPassword());
			// Add employee
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
	public ArrayList<Patient> getPatientByID(String patientID) {
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PATIENT_IDS));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, patientID);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Patient patient = new Patient();
					
					patient.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					patient.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					patient.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					patient.setDob(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					patient.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					patient.setContact(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
					patient.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
					patient.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
					patient.setUser_id(resultSet.getString(CommonConstants.COLUMN_INDEX_NINIE));
					patient.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
					patientList.add(patient);
				}


		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
		return patientList;
	}

	@Override
	public ArrayList<Patient> getPatient() {
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUARY_ALL_PATIENT));
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Patient patient = new Patient();
					
					patient.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					patient.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					patient.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					patient.setDob(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					patient.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					patient.setContact(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
					patient.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
					patient.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
					patient.setUser_id(resultSet.getString(CommonConstants.COLUMN_INDEX_NINIE));
					patient.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
					patientList.add(patient);
				}


		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
		return patientList;
	}

	@Override
	public void updatePatient(Long id, Patient patient) {
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_PATIENT));
			
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, patient.getFirstName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, patient.getLastName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, patient.getContact());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, patient.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, patient.getEmail());
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_SIX, id);
				
				preparedStatement.executeUpdate();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException  e) {
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
	public void removePatient(String patientID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean loginValidate(String userID, String password) {
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement  = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_VALIDATE_LOGIN));
			//connection.setAutoCommit(false);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				return true;
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
		return false;
		
	}

	@Override
	public ArrayList<Patient> findByUserId(String userId) {
		
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_GET_PATIENT_ID_BY_USERID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userId);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Patient patient = new Patient();
					
					patient.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					patient.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					patient.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					patient.setDob(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					patient.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					patient.setContact(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					patient.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
					patient.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
					patient.setUser_id(resultSet.getString(CommonConstants.COLUMN_INDEX_NINIE));
					patient.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
					patientList.add(patient);
				}


		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
		return patientList;
	
	}

	@Override
	public ArrayList<Patient> curentDayAppointmentPatient(Long doctorId) {
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_CURRENT_DAY_APPOINTMENT_PATIENT));
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, doctorId);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Patient patient = new Patient();
					
					patient.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					patient.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					patient.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					
					patientList.add(patient);
				}


		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
		return patientList;
	}

	
}
