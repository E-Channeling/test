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
 * Servlet implementation class AdminUpdateDoctorServlet
 */
@WebServlet("/AdminUpdateDoctorServle")
public class AdminUpdateDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateDoctorServlet() {
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
		doctor.setContact(request.getParameter("dContact"));
		doctor.setAddress(request.getParameter("dAddress"));
		doctor.setEmail(request.getParameter("dmail"));
		
		doctorService.updateDoctor(Long.parseLong(request.getParameter("doctorId")), doctor);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewAllDcotors.jsp");
		dispatcher.forward(request, response);
	}

}
