package com.oop.service;


import java.io.File;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.oop.model.Hospital;
import com.oop.model.Patient;

public interface PatientService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(PatientService.class.getName());


	/**
	 * Add patient for patient table
	 * @param patient
	 */
	public void addPatient(Patient patient, InputStream inputStream);

	/**
	 * Get a particular Patient
	 * 
	 * @param patientID
	 * @return Patient
	 */
	public ArrayList<Patient> getPatientByID(String patientID);
	
	/**
	 * Get all list of patient
	 * 
	 * @return ArrayList<Patient>
	 */
	public ArrayList<Patient> getPatient();
	
	/**
	 * Update existing patient
	 * @param patientID
	 * @param patient
	 * 
	 * @return
	 */
	public void updatePatient(Long id, Patient patient);


	public void removePatient(Long patientID);
	

	public boolean loginValidate(String userID, String password);
	
	public ArrayList<Patient> findByUserId(String userId);
	
	public ArrayList<Patient> curentDayAppointmentPatient(Long doctorId);
	
	
}
