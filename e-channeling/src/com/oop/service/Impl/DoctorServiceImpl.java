package com.oop.service.Impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.model.Doctor;
import com.oop.model.Patient;
import com.oop.service.DoctorService;
import com.oop.util.CommonConstants;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class DoctorServiceImpl implements DoctorService {
	
	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;

	@Override
	public ArrayList<Doctor> findAll() {
		
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
			try {
				connection = DBConnectionUtil.getDBConnection();

					preparedStatement = connection
							.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_ALL_DOCTOR));
				
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Doctor doctor = new Doctor();
					
					doctor.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					doctor.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					doctor.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					doctor.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					doctor.setContact(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					doctor.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
					doctor.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
					doctor.setHospitalId(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
					doctor.setUserId(resultSet.getString(CommonConstants.COLUMN_INDEX_NINIE));
					doctor.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
					doctorList.add(doctor);
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
			return doctorList;
		
	}

	@Override
	public ArrayList<Doctor> findById(Long id) {
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_DOCTOR_BY_ID));
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, id);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Doctor doctor = new Doctor();
					
					doctor.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					doctor.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					doctor.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					doctor.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					doctor.setContact(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					doctor.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
					doctor.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
					doctor.setHospitalId(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
					doctor.setUserId(resultSet.getString(CommonConstants.COLUMN_INDEX_NINIE));
					doctor.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
					doctorList.add(doctor);
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
		return doctorList;
	
	}

	@Override
	public ArrayList<Doctor> findByName(String name) {
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_DOCTOR_BY_NAME));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, "%"+name+"%");
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, "%"+name+"%");
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Doctor doctor = new Doctor();
					
					doctor.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					doctor.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					doctor.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					doctor.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					doctor.setContact(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					doctor.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
					doctor.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
					doctor.setHospitalId(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
					doctor.setUserId(resultSet.getString(CommonConstants.COLUMN_INDEX_NINIE));
					doctor.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
					doctorList.add(doctor);
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
		return doctorList;
	}

	@Override
	public void addDoctor(Doctor doctor) {
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_DOCTOR));
			connection.setAutoCommit(false);
			
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, doctor.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, doctor.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, doctor.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, doctor.getContact());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, doctor.getGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, doctor.getEmail());
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_SEVEN, Long.parseLong(doctor.getHospitalId()));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, doctor.getUserId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINIE, doctor.getPassword());
			
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
	public ArrayList<Doctor> findByUserId(String userId) {
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_DOCTOR_BY_USER_ID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userId);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Doctor doctor = new Doctor();
					
					doctor.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					doctor.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					doctor.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					doctor.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					doctor.setContact(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					doctor.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
					doctor.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
					doctor.setHospitalId(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
					doctor.setUserId(resultSet.getString(CommonConstants.COLUMN_INDEX_NINIE));
					doctor.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
					doctorList.add(doctor);
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
		return doctorList;
	}

	@Override
	public boolean loginValidate(String userID, String password) {
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement  = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_DOCTOR_LOGIN_VALIDATE));
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
	public ArrayList<Doctor> getDoctorByID(String doctorID) {
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_Doctor_IDS));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, doctorID);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Doctor doctor = new Doctor();
					
					doctor.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					doctor.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					doctor.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					doctor.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					doctor.setContact(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					doctor.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
					doctor.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
					doctor.setHospitalId(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
					doctor.setUserId(resultSet.getString(CommonConstants.COLUMN_INDEX_NINIE));
					doctor.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
					doctorList.add(doctor);
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
		return doctorList;
	}
	
	public void updateDoctor(Long id,Doctor doctor) {
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_DOCTOR));
			
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, doctor.getFirstName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, doctor.getLastName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, doctor.getContact());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, doctor.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, doctor.getEmail());
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

}
