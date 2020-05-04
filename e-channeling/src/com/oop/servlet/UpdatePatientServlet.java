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
 * Servlet implementation class UpdatePatientServlet
 */
@WebServlet("/UpdatePatientServle")
public class UpdatePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePatientServlet() {
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
		patient.setContact(request.getParameter("phoneNo"));
		patient.setAddress(request.getParameter("address"));
		patient.setEmail(request.getParameter("email"));
		
		patientService.updatePatient(Long.parseLong(request.getParameter("id")), patient);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/patientDashbord.jsp");
		dispatcher.forward(request, response);
	}

}
