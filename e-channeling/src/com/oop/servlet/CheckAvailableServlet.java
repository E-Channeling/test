package com.oop.servlet;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Schedule;
import com.oop.service.ScheduleService;
import com.oop.service.Impl.ScheduleServiceImpl;

/**
 * Servlet implementation class CheckAvailableServlet
 */
@WebServlet("/CheckAvailableServle")
public class CheckAvailableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAvailableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();
		
		String specilizationID = request.getParameter("spz");
		String hospitalID =request.getParameter("hospital");
		String doctorID =request.getParameter("doctor");
		String date =request.getParameter("date");
		String msg = "Result";
		
		ScheduleService scheduleService = new ScheduleServiceImpl();
		scheduleList = scheduleService.checkAvalabilityTime(Long.parseLong(specilizationID), Long.parseLong(hospitalID), Long.parseLong(doctorID), date);
		
		if(scheduleList.isEmpty()) {
			scheduleList = scheduleService.checkOtherAvalabilityTime(Long.parseLong(specilizationID), Long.parseLong(hospitalID), date);
			msg = "Result Not Found, Other Avalible Displayed";
		}
		
		request.setAttribute("scheduleList", scheduleList);
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/availability.jsp");
		dispatcher.forward(request, response);
	}
	
	/*private Date formatDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return format.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}*/

}
