package com.oop.service;

import java.util.ArrayList;

import com.oop.model.Appoiment;

public interface AppoimentService {
	
	public void addAppointment(Appoiment appoiment);
	
	public ArrayList<Appoiment> findByPatientId(Long patientId);
	
	public ArrayList<Appoiment> getAllStatusBookedAndPendingByPatientId(Long patientId);
	
	public void updateCancelDetails(Long patientId, Long scheduleId, String status);
	
	public ArrayList<Appoiment> getAppoimetByScheduleId(Long sceduleId);
	
	public void updateStatus(Long id, String status);
	
	public ArrayList<Appoiment> getAllAppoimetByScheduleId(Long sceduleId);
	
	public void updateStatusByScheduleId(Long scheduleId, String status);

}
