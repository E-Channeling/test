package com.test.service;

import java.util.ArrayList;

import com.test.model.FeedBack;

public interface iFeedBackService {
	
	public void addFeedBack(FeedBack feedBack);
	
	public ArrayList<FeedBack> getPatient();

}
