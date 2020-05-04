package com.oop.service;

import java.util.ArrayList;
import java.util.Date;

import com.oop.model.Schedule;

public interface ScheduleService {

	public ArrayList<Schedule> checkAvalabilityTime(Long specilizationID, Long hospitalID, Long doctorID, String date);
	
	public ArrayList<Schedule> checkOtherAvalabilityTime(Long specilizationID, Long hospitalID, String date);
	
	public void updateScheduleStatus(Long id, String status);
	
	public ArrayList<Schedule> findById(Long id);
	
	public void addShedule(Schedule schedule);
	
	public ArrayList<Schedule> getAllPendingApproval(Long doctorId);
	
	public ArrayList<Schedule> getAllAvailableSchedule(Long doctorId);
	
	public void removeSchedule(Long Id);
	
	public void updateSchedule(Long id, Schedule schedule);
	
	public ArrayList<Schedule> getAllScheduleByDoctorId(Long doctorId);
	
	public ArrayList<Schedule> getAllCurrentDayScheduleByDoctorId(Long doctorId);

}
