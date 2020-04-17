package com.test.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.model.FeedBack;
import com.test.model.Patient;
import com.test.service.iFeedBackService;
import com.test.util.CommonConstants;
import com.test.util.DBConnectionUtil;
import com.test.util.QueryUtil;

public class FeedbackServiceImpl implements iFeedBackService {
	
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;

	static{
		//create table or drop if exist
		createTreatmentTable();
	}
	
	public static void createTreatmentTable() {
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.dropFeedBackTable());
			// Create new patient table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.createFeedBackTable());

		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	
	
	public void addFeedBack(FeedBack feedBack) {
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			
			preparedStatement = connection
					.prepareStatement(QueryUtil.insertFeedBack());
			connection.setAutoCommit(false);
			
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, feedBack.getPetinatId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, feedBack.getDoctorId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, feedBack.getFeedBackDescription());
			

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
	
	
public ArrayList<FeedBack> getPatient() {
		
		return actionOnFeedBack(null);
	}
	
	
	private ArrayList<FeedBack> actionOnFeedBack(String feedback_id) {
		
		ArrayList<FeedBack> feedBackList = new ArrayList<FeedBack>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			if (feedback_id != null && !feedback_id.isEmpty()) {
				/*
				 * Get employee by ID query will be retrieved from
				 * EmployeeQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.getFeedbackById());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, feedback_id);
			}
			/*
			 * If employee ID is not provided for get employee option it display
			 * all employees
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.selectAllFeedback());
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				FeedBack feedback = new FeedBack();
				feedback.setPetinatId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				feedback.setDoctorId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				feedback.setFeedBackDescription(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				feedBackList.add(feedback);
			}

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
		return feedBackList;
	}


}
