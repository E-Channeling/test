package com.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.Doctor;
import com.test.model.Patient;
import com.test.service.PatientService;
import com.test.service.iDoctorService;
import com.test.serviceImpl.DoctorServiceImpl;
import com.test.serviceImpl.PatientServiceImpl;

/**
 * Servlet implementation class AddDoctorServlet
 */
@WebServlet("/AddDoctorServlet")
public class AddDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctorServlet() {
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
		
		doctor.setDoctorRegID(request.getParameter("docId"));
		doctor.setName(request.getParameter("name"));
		doctor.setSpecialized(request.getParameter("specialized"));
		doctor.setGender(request.getParameter("gender"));
		doctor.setContactNo(request.getParameter("phoneNo"));
		doctor.setHospital(request.getParameter("hospital"));
		doctor.setEmail(request.getParameter("email"));
		doctor.setPassword(request.getParameter("password"));
		
		System.out.println("test");
		iDoctorService doctorService = new DoctorServiceImpl();
		doctorService.addDoctor(doctor);
		System.out.println("test 1");
		request.setAttribute("doctor", doctor);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doctorLogin.jsp");
		dispatcher.forward(request, response);
	}

}
