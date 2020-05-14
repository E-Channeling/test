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

import com.oop.model.Admin;
import com.oop.model.Doctor;
import com.oop.service.AdminService;
import com.oop.util.CommonConstants;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class AdminServiceImpl implements AdminService {
	
	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;
	
	@Override
	public boolean loginValidate(String userID, String password) {
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement  = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_ADMIN_LOGIN_VALIDATE));
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
	public ArrayList<Admin> findByUserId(String userId) {
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		try {
			connection = DBConnectionUtil.getDBConnection();

				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUEARY_ADMIN_BY_USER_ID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userId);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Admin admin = new Admin();
					
					admin.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					admin.setUserId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					admin.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					adminList.add(admin);
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
		return adminList;
	}

}
