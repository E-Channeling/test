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

import com.oop.model.Specilization;
import com.oop.service.SpecilizationService;
import com.oop.util.CommonConstants;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class SpecilizationServiceImpl implements SpecilizationService {
	
	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;
	
	
	@Override
	public ArrayList<Specilization> findAll() {

		ArrayList<Specilization> specilizationList = new ArrayList<Specilization>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_ALL_SPECILIZATION));
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Specilization specilization = new Specilization();
				
				specilization.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				specilization.setSpecName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				specilizationList.add(specilization);
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
		return specilizationList;
	}


	@Override
	public ArrayList<Specilization> findById(Long id) {
		ArrayList<Specilization> specilizationList = new ArrayList<Specilization>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_SPECILIZATION_BY_ID));
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Specilization specilization = new Specilization();
				
				specilization.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				specilization.setSpecName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				specilizationList.add(specilization);
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
		return specilizationList;
	}

}
