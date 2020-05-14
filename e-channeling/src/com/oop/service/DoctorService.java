package com.oop.service;

import java.util.ArrayList;

import com.oop.model.Doctor;
import com.oop.model.Patient;


public interface DoctorService {
	
	public ArrayList<Doctor> findAll();
	
	public ArrayList<Doctor> findById(Long id);
	
	public ArrayList<Doctor> findByName(String name);
	
	public void addDoctor(Doctor doctor);

	public ArrayList<Doctor> findByUserId(String userId);
	
	public boolean loginValidate(String userID, String password);
	
	
	public ArrayList<Doctor> getDoctorByID(String doctorID);
	
	public void updateDoctor(Long id, Doctor doctor);

}
