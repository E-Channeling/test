package com.oop.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.print.attribute.standard.SheetCollate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.Enum.AppoimentStatus;
import com.oop.Enum.ScheduleStatus;
import com.oop.model.Appoiment;
import com.oop.model.Patient;
import com.oop.model.Schedule;
import com.oop.service.AppoimentService;
import com.oop.service.PatientService;
import com.oop.service.ScheduleService;
import com.oop.service.Impl.AppoimentServiceImpl;
import com.oop.service.Impl.PatientServiceImpl;
import com.oop.service.Impl.ScheduleServiceImpl;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServle")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
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
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		//ArrayList<Patient> patientList = new ArrayList<Patient>();
		//PatientService patientService = new PatientServiceImpl(); 
		
		//patientList = patientService.findByUserId(request.getParameter("name"));
		Appoiment appoiment = new Appoiment();
		appoiment.setScheduleId(request.getParameter("book"));
		appoiment.setPatientId(request.getParameter("id"));
		appoiment.setStatus(AppoimentStatus.PENDING.toString());
		appoiment.setAppoimentDate(strDate);

		AppoimentService appoimentService = new AppoimentServiceImpl(); 
		appoimentService.addAppointment(appoiment);
		
		ScheduleService scheduleService = new ScheduleServiceImpl();
		//scheduleService.updateScheduleStatus(Long.parseLong(request.getParameter("book")), ScheduleStatus.BOOKED.toString());
		scheduleService.updateScheduleStatus(Long.parseLong(request.getParameter("book")), ScheduleStatus.BOOKED.toString());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/patientHome.jsp");
		dispatcher.forward(request, response);
		
	}

}
