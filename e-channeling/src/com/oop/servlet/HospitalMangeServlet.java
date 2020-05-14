package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Hospital;
import com.oop.model.Schedule;
import com.oop.service.HospitalService;
import com.oop.service.ScheduleService;
import com.oop.service.Impl.HospitalServiceImpl;
import com.oop.service.Impl.ScheduleServiceImpl;

/**
 * Servlet implementation class HospitalMangeServlet
 */
@WebServlet("/HospitalMangeServle")
public class HospitalMangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalMangeServlet() {
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
			HospitalService hospitalService = new HospitalServiceImpl();
			ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();
			hospitalList = hospitalService.findById(Long.parseLong(request.getParameter("hospitalId")));
			request.setAttribute("hospitalList", hospitalList);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateHospital.jsp");
			dispatcher.forward(request, response);
		}
		else if(delete != null) {
			HospitalService hospitalService = new HospitalServiceImpl();
			hospitalService.deleteHospital(Long.parseLong(request.getParameter("hospitalId")));
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewAllHospital.jsp");
			dispatcher.forward(request, response);
		}
	}

}
