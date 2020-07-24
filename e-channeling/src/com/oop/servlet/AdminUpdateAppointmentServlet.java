package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Appoiment;
import com.oop.service.AppoimentService;
import com.oop.service.Impl.AppoimentServiceImpl;

/**
 * Servlet implementation class AdminUpdateAppointmentServlet
 */
@WebServlet("/AdminUpdateAppointmentServle")
public class AdminUpdateAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateAppointmentServlet() {
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
		
		Appoiment appointment = new Appoiment();
		AppoimentService appointmentService =  new AppoimentServiceImpl();
		
		appointment.setAppoimentDate(request.getParameter("appdate"));
		appointment.setStatus(request.getParameter("appstatus"));
		
		appointmentService.updateAppointment(Long.parseLong(request.getParameter("appointmentId")), appointment);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewAllAppointments.jsp");
		dispatcher.forward(request, response);
	}

}
