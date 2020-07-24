package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Patient;
import com.oop.service.PatientService;
import com.oop.service.Impl.PatientServiceImpl;

/**
 * Servlet implementation class AdminUpdatePatientServlet
 */
@WebServlet("/AdminUpdatePatientServle")
public class AdminUpdatePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdatePatientServlet() {
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
		
		Patient patient = new Patient();
		PatientService patientService =  new PatientServiceImpl();
		
		patient.setFirstName(request.getParameter("fName"));
		patient.setLastName(request.getParameter("lName"));
		patient.setContact(request.getParameter("pContact"));
		patient.setAddress(request.getParameter("pAddress"));
		patient.setEmail(request.getParameter("pmail"));
		
		patientService.updatePatient(Long.parseLong(request.getParameter("patientId")), patient);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewAllPatients.jsp");
		dispatcher.forward(request, response);
	}

}
