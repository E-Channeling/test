package com.oop.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.Enum.ScheduleStatus;
import com.oop.model.Schedule;
import com.oop.service.ScheduleService;
import com.oop.service.Impl.ScheduleServiceImpl;

/**
 * Servlet implementation class AddSchedule
 */
@WebServlet("/AddScheduleServle")
public class AddScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddScheduleServlet() {
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
		Schedule schedule = new Schedule();
		ScheduleService scheduleService = new ScheduleServiceImpl();
		SimpleDateFormat format = new SimpleDateFormat("hh:mm");
		String fTime = request.getParameter("fromTime");
		String tTime = request.getParameter("toTime");
		Date date1 = null;
		Date date2 = null;
		Date date3 = null;
		String temp = null;
		int addMin = Integer.parseInt(request.getParameter("minTime"));
		
		try {
			date3 = format.parse(tTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		do {
			Date date = new Date();
			
			try {
				date1 = format.parse(fTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			date.setTime((((Integer.parseInt(fTime.split(":")[1]))*60 + (Integer.parseInt(fTime.split(":")[1]))) + date1.getTimezoneOffset())*60000);
			date.setTime(date1.getTime()+ addMin * 60000);
			temp = date.getHours() + ":" + date.getMinutes();
			schedule.setFromTime(fTime);
			schedule.setToTime(temp);
			schedule.setDoctorId(request.getParameter("id"));
			schedule.setHospitalId(request.getParameter("hospital"));
			schedule.setSpecilizationId(request.getParameter("spz"));
			schedule.setDate(request.getParameter("date"));
			schedule.setStatus(ScheduleStatus.AVAILABLE.toString());
			
			fTime = temp;
			try {
				date2 = format.parse(temp);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(date2.getHours() >= date3.getHours()) {
				if(date2.getMinutes() > date3.getMinutes())
					break;
			}
			scheduleService.addShedule(schedule);
			
		}while(!(date2.getHours() == date3.getHours() && date2.getMinutes() == date3.getMinutes()));
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doctorDashbord.jsp");
		dispatcher.forward(request, response);
	}

}
