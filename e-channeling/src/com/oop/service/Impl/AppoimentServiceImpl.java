package com.oop.service.Impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.Enum.AppoimentStatus;
import com.oop.model.Appoiment;
import com.oop.model.Doctor;
import com.oop.service.AppoimentService;
import com.oop.util.CommonConstants;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class AppoimentServiceImpl implements AppoimentService {
	
	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;
	
	Calendar calendar = Calendar.getInstance();
	java.util.Date now = calendar.getTime();
	Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

	@Override
	public void addAppointment(Appoiment appoiment) {
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_APPOINMENT));
			connection.setAutoCommit(false);
			
			
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, Long.parseLong(appoiment.getPatientId()));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_TWO, Long.parseLong(appoiment.getScheduleId()));
			preparedStatement.setTimestamp(CommonConstants.COLUMN_INDEX_THREE, currentTimestamp);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, appoiment.getStatus());
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
	public ArrayList<Appoiment> findAll() {
		ArrayList<Appoiment> appointmentList = new ArrayList<Appoiment>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_ALL_APPOINTMENT));
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Appoiment appointment = new Appoiment();
				
				appointment.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				appointment.setPatientId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				appointment.setScheduleId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				appointment.setAppoimentDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				appointment.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				appointment.setCancelDate(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				appointmentList.add(appointment);
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
		return appointmentList;
	}
	
	@Override
	public ArrayList<Appoiment> findById(Long id) {
		ArrayList<Appoiment> appointmentList = new ArrayList<Appoiment>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_APPOINTMENT_BY_APPOINTMENT_ID));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, id);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Appoiment appointment = new Appoiment();
					
					appointment.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					appointment.setPatientId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					appointment.setScheduleId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					appointment.setAppoimentDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					appointment.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					appointmentList.add(appointment);
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
		return appointmentList;
	
	}

	@Override
	public ArrayList<Appoiment> findByPatientId(Long patientId) {
		
		ArrayList<Appoiment> appoimentList = new ArrayList<Appoiment>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_APPOINTMENT_BY_PATIENT_ID));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, patientId);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Appoiment appoiment = new Appoiment();
					
					appoiment.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					appoiment.setPatientId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					appoiment.setScheduleId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					appoiment.setAppoimentDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					appoiment.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					appoimentList.add(appoiment);
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
		return appoimentList;
	
	}

	@Override
	public ArrayList<Appoiment> getAllStatusBookedAndPendingByPatientId(Long patientId) {
		ArrayList<Appoiment> appoimentList = new ArrayList<Appoiment>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_CANCEL_APPOINTMENT_BY_PATIENT_ID));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, patientId);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Appoiment appoiment = new Appoiment();
					
					appoiment.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					appoiment.setPatientId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					appoiment.setScheduleId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					appoiment.setAppoimentDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					appoiment.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					appoimentList.add(appoiment);
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
		return appoimentList;
	
	}

	@Override
	public void updateCancelDetails(Long patientId, Long scheduleId, String status) {
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_UPDATE_CANCEL_DETAILS));
			
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, status);
				preparedStatement.setTimestamp(CommonConstants.COLUMN_INDEX_TWO, currentTimestamp);
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_THREE, patientId);
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_FOUR, scheduleId);
				
				preparedStatement.executeUpdate();

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
	public ArrayList<Appoiment> getAppoimetByScheduleId(Long sceduleId) {
		ArrayList<Appoiment> appoimentList = new ArrayList<Appoiment>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_GET_APPOIMENT_BY_SCHEDULE_ID));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, sceduleId);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Appoiment appoiment = new Appoiment();
					
					appoiment.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					appoiment.setPatientId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					appoiment.setScheduleId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					appoiment.setAppoimentDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					appoiment.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					appoimentList.add(appoiment);
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
		return appoimentList;
	}

	@Override
	public void updateStatus(Long id, String status) {
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_UPDATE_APPOIMENT_STATUS));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, status);
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_TWO, id);
				
				preparedStatement.executeUpdate();

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
	public ArrayList<Appoiment> getAllAppoimetByScheduleId(Long sceduleId) {
		ArrayList<Appoiment> appoimentList = new ArrayList<Appoiment>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_GET_ALL_APPOIMENT_BY_SCHEDULE_ID));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, sceduleId);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Appoiment appoiment = new Appoiment();
					
					appoiment.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					appoiment.setPatientId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					appoiment.setScheduleId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					appoiment.setAppoimentDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					appoiment.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					appoimentList.add(appoiment);
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
		return appoimentList;
	}

	@Override
	public void updateStatusByScheduleId(Long scheduleId, String status) {
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_UPDATE_APPOINTMENT_STATUS_BY_SCHEDULE_ID));
			
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, status);
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_TWO, scheduleId);
				
				
				preparedStatement.executeUpdate();

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
	public void deleteAppointment(Long id) {
		if(id != null) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_REMOVE_APPOINTMENT));
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, id);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
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
	
	@Override
	public void updateAppointment(Long id, Appoiment appointment) {
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_APPOINTMENT));
			
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, appointment.getAppoimentDate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, appointment.getStatus());
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_THREE, id);
				
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
