package com.oop.model;

public class Appoiment {
	
	private String id;
	private String patientId;
	private String scheduleId;
	private String appoimentDate;
	private String status;
	private String cancelDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getAppoimentDate() {
		return appoimentDate;
	}
	public void setAppoimentDate(String appoimentDate) {
		this.appoimentDate = appoimentDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
}
