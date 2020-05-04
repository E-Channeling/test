package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.Enum.AppoimentStatus;
import com.oop.Enum.ScheduleStatus;
import com.oop.service.AppoimentService;
import com.oop.service.ScheduleService;
import com.oop.service.Impl.AppoimentServiceImpl;
import com.oop.service.Impl.ScheduleServiceImpl;

/**
 * Servlet implementation class CancelBookServlet
 */
@WebServlet("/CancelBookServle")
public class CancelBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelBookServlet() {
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
		
		AppoimentService appoimentService = new AppoimentServiceImpl(); 
		appoimentService.updateCancelDetails(Long.parseLong(request.getParameter("id")), Long.parseLong(request.getParameter("cancel")), AppoimentStatus.CANCEL.toString());
		ScheduleService scheduleService = new ScheduleServiceImpl();
		scheduleService.updateScheduleStatus(Long.parseLong(request.getParameter("cancel")), ScheduleStatus.AVAILABLE.toString());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/patientHome.jsp");
		dispatcher.forward(request, response);
	}

}
