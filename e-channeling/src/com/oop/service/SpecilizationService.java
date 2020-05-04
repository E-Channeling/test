package com.oop.service;

import java.util.ArrayList;

import com.oop.model.Specilization;

public interface SpecilizationService {
	
	public ArrayList<Specilization> findAll();
	
	public ArrayList<Specilization> findById(Long id);
	
}
