package com.test.service;

import com.test.model.Patient;
import java.util.ArrayList;
import java.util.logging.Logger;

public interface PatientService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(PatientService.class.getName());


	/**
	 * Add patient for patient table
	 * @param patient
	 */
	public void addPatient(Patient patient);

	/**
	 * Get a particular Patient
	 * 
	 * @param patientID
	 * @return Patient
	 */
	public Patient getPatientByID(String patientID);
	
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
	public Patient updatePatient(String employeeID, Patient employee);

	/**
	 * Remove existing patient
	 * 
	 * @param patientID
	 */
	public void removePatient(String patientID);
}
