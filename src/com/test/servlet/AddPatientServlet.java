package com.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.Patient;
import com.test.service.PatientService;
import com.test.serviceImpl.PatientServiceImpl;

/**
 * Servlet implementation class AddPatient
 */
@WebServlet("/AddPatient")
public class AddPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatientServlet() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		Patient patient = new Patient();
		
		patient.setfName(request.getParameter("fName"));
		patient.setlName(request.getParameter("lName"));
		patient.setDOB(request.getParameter("DOB"));
		patient.setPhoneNo(request.getParameter("phoneNo"));
		patient.setAddress(request.getParameter("address"));
		patient.setGender(request.getParameter("gender"));
		patient.setEmail(request.getParameter("email"));
		patient.setPassword(request.getParameter("password"));
		
		PatientService patientService = new PatientServiceImpl();
		patientService.addPatient(patient);

		request.setAttribute("patient", patient);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/patientLogin.jsp");
		dispatcher.forward(request, response);
		
	}

}
