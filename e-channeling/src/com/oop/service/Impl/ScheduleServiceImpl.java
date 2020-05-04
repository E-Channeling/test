package com.oop.service.Impl;

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

import com.oop.Enum.ScheduleStatus;
import com.oop.model.Schedule;
import com.oop.service.ScheduleService;
import com.oop.util.CommonConstants;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class ScheduleServiceImpl implements ScheduleService {
	
	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;
	
	@Override
	public ArrayList<Schedule> checkAvalabilityTime(Long specilizationID, Long hospitalID, Long doctorID, String date) {
		ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_GET_AVALABILITY));
			
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, hospitalID);
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_TWO, doctorID);
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_THREE, specilizationID);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, date);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, ScheduleStatus.AVAILABLE.toString());
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Schedule schedule = new Schedule();
				
				schedule.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				schedule.setHospitalId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				schedule.setDoctorId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				schedule.setSpecilizationId(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				schedule.setFromTime(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				schedule.setToTime(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				schedule.setDate(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));

				scheduleList.add(schedule);
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
		return scheduleList;
		
	}
	

	@Override
	public ArrayList<Schedule> checkOtherAvalabilityTime(Long specilizationID, Long hospitalID, String date) {
		ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_GET_OTHER_AVALABILITY));
			
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, hospitalID);
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_TWO, specilizationID);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, date);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, ScheduleStatus.AVAILABLE.toString());
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Schedule schedule = new Schedule();
				
				schedule.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				schedule.setHospitalId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				schedule.setDoctorId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				schedule.setSpecilizationId(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				schedule.setFromTime(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				schedule.setToTime(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				schedule.setDate(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));

				scheduleList.add(schedule);
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
		return scheduleList;
	}


	@Override
	public void updateScheduleStatus(Long id, String status) {
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_UPDATE_SCHEDULE_STATUS));
			
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
	public ArrayList<Schedule> findById(Long id) {
		ArrayList<Schedule> scheduleLi = new ArrayList<Schedule>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_SCHEDULE_BY_ID));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, id);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Schedule schedule = new Schedule();
					
					schedule.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					schedule.setHospitalId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					schedule.setDoctorId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					schedule.setSpecilizationId(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					schedule.setFromTime(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					schedule.setToTime(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
					schedule.setDate(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
					schedule.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
					scheduleLi.add(schedule);
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
		return scheduleLi;
	}


	@Override
	public void addShedule(Schedule schedule) {
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_SCHEDULE));
			connection.setAutoCommit(false);
			
			
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, Long.parseLong(schedule.getHospitalId()));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_TWO, Long.parseLong(schedule.getDoctorId()));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_THREE, Long.parseLong(schedule.getSpecilizationId()));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, schedule.getFromTime());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, schedule.getToTime());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, schedule.getDate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, schedule.getStatus());

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
	public ArrayList<Schedule> getAllPendingApproval(Long doctorId) {
		ArrayList<Schedule> scheduleLi = new ArrayList<Schedule>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_GET_APPROVAL_PENDING));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, doctorId);
			//preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, AppoimentStatus.PENDING.toString());
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Schedule schedule = new Schedule();
					
					schedule.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					schedule.setHospitalId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					schedule.setDoctorId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					schedule.setSpecilizationId(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					schedule.setFromTime(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					schedule.setToTime(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
					schedule.setDate(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
					schedule.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
					scheduleLi.add(schedule);
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
		return scheduleLi;
	}


	@Override
	public ArrayList<Schedule> getAllAvailableSchedule(Long doctorId) {
		
		ArrayList<Schedule> scheduleLi = new ArrayList<Schedule>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_GET_ALL_AVAILABLE_SCHEDULE));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, doctorId);
			//preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, AppoimentStatus.PENDING.toString());
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Schedule schedule = new Schedule();
					
					schedule.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					schedule.setHospitalId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					schedule.setDoctorId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					schedule.setSpecilizationId(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					schedule.setFromTime(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					schedule.setToTime(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
					schedule.setDate(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
					schedule.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
					scheduleLi.add(schedule);
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
		return scheduleLi;
	}


	@Override
	public void removeSchedule(Long Id) {
		
		if (Id != null) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_REMOVE_SCHEDULE));
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, Id);
				preparedStatement.executeUpdate();
				
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
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
	public void updateSchedule(Long id, Schedule schedule) {
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_UPDATE_SCHEDULE));
			
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, Long.parseLong(schedule.getSpecilizationId()));
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_TWO, Long.parseLong(schedule.getHospitalId()));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, schedule.getDate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, schedule.getFromTime());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, schedule.getToTime());
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
	public ArrayList<Schedule> getAllScheduleByDoctorId(Long doctorId) {
		ArrayList<Schedule> scheduleLi = new ArrayList<Schedule>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_GET_ALL_APPOINTMENT));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, doctorId);
			//preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, AppoimentStatus.PENDING.toString());
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Schedule schedule = new Schedule();
					
					schedule.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					schedule.setHospitalId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					schedule.setDoctorId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					schedule.setSpecilizationId(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					schedule.setFromTime(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					schedule.setToTime(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
					schedule.setDate(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
					schedule.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
					scheduleLi.add(schedule);
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
		return scheduleLi;
	}


	@Override
	public ArrayList<Schedule> getAllCurrentDayScheduleByDoctorId(Long doctorId) {
		ArrayList<Schedule> scheduleLi = new ArrayList<Schedule>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_CURRENT_DAY_SCHEDULE_BY_DOCTOR));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, doctorId);
			//preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, AppoimentStatus.PENDING.toString());
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Schedule schedule = new Schedule();
					
					schedule.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					schedule.setHospitalId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					schedule.setDoctorId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					schedule.setSpecilizationId(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					schedule.setFromTime(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
					schedule.setToTime(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
					schedule.setDate(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
					schedule.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
					scheduleLi.add(schedule);
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
		return scheduleLi;
	}

}
