package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Doctor;
import com.oop.service.DoctorService;
import com.oop.service.Impl.DoctorServiceImpl;


/**
 * Servlet implementation class UpdateDoctorServlet
 */
@WebServlet("/UpdateDoctorServlet")
public class UpdateDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDoctorServlet() {
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
		
		Doctor doctor = new Doctor();
		DoctorService doctorService =  new DoctorServiceImpl();
		
		doctor.setFirstName(request.getParameter("fName"));
		doctor.setLastName(request.getParameter("lName"));
		doctor.setContact(request.getParameter("phoneNo"));
		doctor.setAddress(request.getParameter("address"));
		doctor.setEmail(request.getParameter("email"));
		
		doctorService.updateDoctor(Long.parseLong(request.getParameter("id")), doctor);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doctorDashbord.jsp");
		dispatcher.forward(request, response);
	}

}
