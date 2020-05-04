package com.oop.service.Impl;

import java.io.IOException;
import java.sql.Connection;
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

import com.oop.model.Feedback;
import com.oop.model.Hospital;
import com.oop.service.FeedbackService;
import com.oop.util.CommonConstants;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class FeedbackServiceImpl implements FeedbackService {

	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;
	
	Calendar calendar = Calendar.getInstance();
	java.util.Date now = calendar.getTime();
	Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
	
	@Override
	public void addFeedback(Feedback feedback) {
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_INSERT_FEEDBACK));
			connection.setAutoCommit(false);
			
			
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, Long.parseLong(feedback.getPatientId()));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_TWO, Long.parseLong(feedback.getDoctorId()));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, feedback.getDescription());
			preparedStatement.setTimestamp(CommonConstants.COLUMN_INDEX_FOUR, currentTimestamp);
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
	public ArrayList<Feedback> findByDoctorId(Long doctorId) {
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_FEEDBACK_BY_DOCTOR_ID));
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, doctorId);
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Feedback feedback = new Feedback();
				
				feedback.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				feedback.setPatientId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				feedback.setDoctorId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				feedback.setDescription(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				feedback.setDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				feedbackList.add(feedback);
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
		return feedbackList;
	}
}
