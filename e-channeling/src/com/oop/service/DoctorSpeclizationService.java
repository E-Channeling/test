package com.oop.service;

import java.util.ArrayList;

import com.oop.model.DoctorSpeclization;

public interface DoctorSpeclizationService {
	
	public ArrayList<DoctorSpeclization> findByDoctorId(Long doctorId);

}
