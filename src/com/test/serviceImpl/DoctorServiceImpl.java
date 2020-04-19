package com.test.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.test.model.Doctor;
import com.test.model.Patient;
import com.test.service.iDoctorService;
import com.test.util.CommonConstants;
import com.test.util.DBConnectionUtil;
import com.test.util.QueryUtil;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class DoctorServiceImpl implements iDoctorService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createPatientTable();
	}
	
	private PreparedStatement preparedStatement;
	
	public static void createPatientTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.dropDoctorTable());
			// Create new patient table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.createDoctorTable());

		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	public void addDoctor(Doctor doctor) {
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			
			preparedStatement = connection
					.prepareStatement(QueryUtil.insertDoctor());
			connection.setAutoCommit(false);
			
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, doctor.getDoctorRegID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, doctor.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, doctor.getSpecialized());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, doctor.getGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, doctor.getContactNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, doctor.getHospital());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, doctor.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, doctor.getPassword());
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

public static boolean login(Doctor doctor) {

		boolean status = false;
		Connection con = null;
		PreparedStatement preparedStatement = null;
	
try {


con = DBConnectionUtil.getDBConnection();
    
	preparedStatement  = con
    .prepareStatement(QueryUtil.selectDoctor());
    preparedStatement.setString(1, doctor.getEmail());
    preparedStatement.setString(2, doctor.getPassword());
    System.out.println("methanata awa");
    System.out.println(preparedStatement);
    ResultSet rs = preparedStatement.executeQuery();
    System.out.println(rs);
    status = rs.next();
    System.out.println(status);


} catch (SQLException | ClassNotFoundException e) {
    // process sql exception
    System.out.println(e);
}

return status;

}


			public ArrayList<Doctor> getCurrentDoctor(String email){
//				HttpSession session=request.getSession();  
//				String email=(String)session.getAttribute("email");
				
				return actionOnGetCurrentDoctor(email);
			}
			
			private ArrayList<Doctor> actionOnGetCurrentDoctor(String email){
				
				ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
				try {
					connection = DBConnectionUtil.getDBConnection();
					/*
					 * Before fetching employee it checks whether employee ID is
					 * available
					 */
					if (email != null && !email.isEmpty()) {
						/*
						 * Get employee by ID query will be retrieved from
						 * EmployeeQuery.xml
						 */
						preparedStatement = connection
								.prepareStatement(QueryUtil.getDoctorById());
						preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, email);
					}
					else {
						preparedStatement = connection
								.prepareStatement(QueryUtil.selectallDoctor());
					}
					ResultSet resultSet = preparedStatement.executeQuery();

					while (resultSet.next()) {
						Doctor doctor = new Doctor();
						doctor.setDoctorRegID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
						doctor.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
						doctor.setSpecialized(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
						doctor.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
						doctor.setHospital(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
						doctor.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
						doctor.setContactNo(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
						doctor.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
						doctor.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_NINIE));
						doctorList.add(doctor);
					}
				}catch (SQLException | ClassNotFoundException e) {
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
			public ArrayList<Doctor> getDoctorcategory() {
				
				return actionOnDoctorcategory();
			}
			
			
			private ArrayList<Doctor> actionOnDoctorcategory() {
				
				ArrayList<Doctor> doctorCatList = new ArrayList<Doctor>();
				try {
					connection = DBConnectionUtil.getDBConnection();
				
						preparedStatement = connection
								.prepareStatement(QueryUtil.selectcategory());
				
					ResultSet resultSet = preparedStatement.executeQuery();

					while (resultSet.next()) {
						Doctor doctor = new Doctor();
						doctor.setSpecialized(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
						doctorCatList.add(doctor);
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
				return doctorCatList;
			}
			
			@Override
			public ArrayList<Doctor> getDoctorHospital() {
				
				return actionOnDoctorHospital();
			}
			
			
			private ArrayList<Doctor> actionOnDoctorHospital() {
				
				ArrayList<Doctor> doctorHostList = new ArrayList<Doctor>();
				try {
					connection = DBConnectionUtil.getDBConnection();
				
						preparedStatement = connection
								.prepareStatement(QueryUtil.selectHospital());
				
					ResultSet resultSet = preparedStatement.executeQuery();

					while (resultSet.next()) {
						Doctor doctor = new Doctor();
						doctor.setHospital(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
						doctorHostList.add(doctor);
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
				return doctorHostList;
			}

			@Override
			public ArrayList<Doctor> getDoctorListForBooking(String category,String hospital) {
				
				return actionOnDoctorListForBooking(category,hospital);
			}
			
			
			private ArrayList<Doctor> actionOnDoctorListForBooking(String category,String hospital ) {
				
				ArrayList<Doctor> doctorListForBooking = new ArrayList<Doctor>();
				try {
					connection = DBConnectionUtil.getDBConnection();
					preparedStatement = connection
							.prepareStatement(QueryUtil.selectDoctorForBooking());
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, category);
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, hospital);
				
					ResultSet resultSet = preparedStatement.executeQuery();

					while (resultSet.next()) {
						Doctor doctor = new Doctor();
						doctor.setDoctorRegID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
						doctor.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
						
						doctorListForBooking.add(doctor);
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
				return doctorListForBooking;
			}

		



}
