package com.oop.service;

import java.util.ArrayList;

import com.oop.model.Hospital;

public interface HospitalService {

	public ArrayList<Hospital> findAll();
	
	public ArrayList<Hospital> findById(Long id);

}
