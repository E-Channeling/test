package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class AppointmentManageServlet
 */
@WebServlet("/AppointmentManageServle")
public class AppointmentManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentManageServlet() {
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
		String update = request.getParameter("update");
		String delete = request.getParameter("delete");
		if(update != null) {
			AppoimentService appointmentService = new AppoimentServiceImpl();
			ArrayList<Appoiment> appointmentList = new ArrayList<Appoiment>();
			appointmentList = appointmentService.findById(Long.parseLong(request.getParameter("appointmentId")));
			request.setAttribute("appointmentList", appointmentList);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminUpdateAppointment.jsp");
			dispatcher.forward(request, response);
		}
		else if(delete != null) {
			AppoimentService appointmentService = new AppoimentServiceImpl();
			appointmentService.deleteAppointment(Long.parseLong(request.getParameter("appointmentId")));
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewAllAppointments.jsp");
			dispatcher.forward(request, response);
		}
	}

}
