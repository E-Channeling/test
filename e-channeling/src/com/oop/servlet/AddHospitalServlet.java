package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Feedback;
import com.oop.model.Hospital;
import com.oop.service.FeedbackService;
import com.oop.service.HospitalService;
import com.oop.service.Impl.FeedbackServiceImpl;
import com.oop.service.Impl.HospitalServiceImpl;

/**
 * Servlet implementation class AddHospitalServlet
 */
@WebServlet("/AddHospitalServle")
public class AddHospitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHospitalServlet() {
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
		Hospital hospital = new Hospital();
		
		hospital.setName(request.getParameter("hName"));
		hospital.setAddress(request.getParameter("hAddress"));
		hospital.setContact(request.getParameter("hContact"));
		
		HospitalService hospitalService = new HospitalServiceImpl();
		hospitalService.addHospital(hospital);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addHospital.jsp");
		dispatcher.forward(request, response);
	}

}
