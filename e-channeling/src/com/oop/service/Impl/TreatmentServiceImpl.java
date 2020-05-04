package com.oop.service.Impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.model.Treatment;
import com.oop.service.TreatmentService;
import com.oop.util.CommonConstants;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class TreatmentServiceImpl implements TreatmentService {
	
	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;
	
	Calendar calendar = Calendar.getInstance();
	java.util.Date now = calendar.getTime();
	Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

	@Override
	public void addTreatmentDetails(Treatment treatment) {
		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_TREATMENT));
			connection.setAutoCommit(false);
			
			
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, Long.parseLong(treatment.getPatientId()));
			preparedStatement.setLong(CommonConstants.COLUMN_INDEX_TWO, Long.parseLong(treatment.getDoctorId()));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, treatment.getDescription());
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

}
