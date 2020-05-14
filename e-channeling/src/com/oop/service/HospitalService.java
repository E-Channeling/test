package com.oop.service;

import java.util.ArrayList;

import com.oop.model.Hospital;

public interface HospitalService {

	public ArrayList<Hospital> findAll();
	
	public ArrayList<Hospital> findById(Long id);
	
	public void addHospital(Hospital hospital);
	
	public void deleteHospital(Long Id);
	
	public void updateHospital(Long id, Hospital hospital);

}
