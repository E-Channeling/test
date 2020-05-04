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

import com.oop.model.DoctorSpeclization;
import com.oop.service.DoctorSpeclizationService;
import com.oop.util.CommonConstants;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class DoctorSpeclizationServiceImpl implements DoctorSpeclizationService {
	
	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;

	@Override
	public ArrayList<DoctorSpeclization> findByDoctorId(Long doctorId) {
		ArrayList<DoctorSpeclization> doctorSpeclizationList = new ArrayList<DoctorSpeclization>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_DOCTOR_SPECILIZATION_BY_DOCTOR_ID));
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, doctorId);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					DoctorSpeclization doctorSpeclization = new DoctorSpeclization();
					
					doctorSpeclization.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					doctorSpeclization.setDoctorId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					doctorSpeclization.setSpecilizationId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					
					doctorSpeclizationList.add(doctorSpeclization);
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
		return doctorSpeclizationList;
	}

}
