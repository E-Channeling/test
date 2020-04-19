package com.test.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.test.model.Doctor;


public interface iDoctorService {
	
	public void addDoctor(Doctor doctor);
	
	public ArrayList<Doctor> getCurrentDoctor(String email);

	public ArrayList<Doctor> getDoctorcategory();
	
	public ArrayList<Doctor> getDoctorHospital();
	
	public ArrayList<Doctor> getDoctorListForBooking(String category,String hospital);
}
