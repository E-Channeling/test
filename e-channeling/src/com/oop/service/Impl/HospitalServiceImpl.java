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

import com.oop.model.Hospital;
import com.oop.model.Specilization;
import com.oop.service.HospitalService;
import com.oop.util.CommonConstants;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class HospitalServiceImpl implements HospitalService {
	
	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;
	
	
	@Override
	public ArrayList<Hospital> findAll() {

		ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_ALL_HOSPITAL));
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Hospital hospital = new Hospital();
				
				hospital.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				hospital.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				hospital.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				hospital.setContact(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				hospitalList.add(hospital);
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
		return hospitalList;
	}


	@Override
	public ArrayList<Hospital> findById(Long id) {
		ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_HOSPITAL_BY_ID));
				preparedStatement.setLong(CommonConstants.COLUMN_INDEX_ONE, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Hospital hospital = new Hospital();
				
				hospital.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				hospital.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				hospital.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				hospital.setContact(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				hospitalList.add(hospital);
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
		return hospitalList;
	}

}
