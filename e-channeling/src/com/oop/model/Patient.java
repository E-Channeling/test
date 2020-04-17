package com.oop.model;

public class Patient {
	
	 private String fName;
	 private String lName;
	 private String password;
	 private String email;
	 private String DOB;
	 private String gender;
	 private String address;
	 private String phoneNo;
	 
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
/*	@Override
	public String toString() {
		return "Patient [fName=" + fName + ", lName=" + lName + ", password=" + password + ", email=" + email + ", DOB="
				+ DOB + ", gender=" + gender + ", address=" + address + ", phoneNo=" + phoneNo + "]";
	}*/
	 
}
