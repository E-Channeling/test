package com.oop.service;

import java.util.ArrayList;

import com.oop.model.Admin;
import com.oop.model.Doctor;

public interface AdminService {
	
	public boolean loginValidate(String userID, String password);
	
	public void addAdmin(Admin admin);

	public ArrayList<Admin> findByUserId(String userId);
	
	public ArrayList<Admin> findById(String id);

	public void changePassword(String id, String passowrd);
}
