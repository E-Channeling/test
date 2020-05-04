package com.oop.service;

import java.util.ArrayList;

import com.oop.model.Feedback;

public interface FeedbackService {
	
	public void addFeedback(Feedback feedback);
	
	ArrayList<Feedback> findByDoctorId(Long doctorId);

}
