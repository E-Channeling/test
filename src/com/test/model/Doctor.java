package com.test.model;

public class Doctor {
	private String doctorRegID;
	private String name;
	private String specialized;
	private String Gender;
	private String hospital;
	private String contactNo;
	private String email;
	private String password;
	
	
	public String getDoctorRegID() {
		return doctorRegID;
	}
	public void setDoctorRegID(String doctorRegID) {
		this.doctorRegID = doctorRegID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialized() {
		return specialized;
	}
	public void setSpecialized(String specialized) {
		this.specialized = specialized;
	}
	
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
