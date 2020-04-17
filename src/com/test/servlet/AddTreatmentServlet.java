package com.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.test.model.Treatment;
import com.test.service.iDoctorService;
import com.test.service.iTreatmentService;
import com.test.serviceImpl.DoctorServiceImpl;
import com.test.serviceImpl.TreatmentServiceImpl;

/**
 * Servlet implementation class TreatmentServlet
 */
@WebServlet("/AddTreatmentServlet")
public class AddTreatmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTreatmentServlet() {
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
		
		Treatment treatment = new Treatment();
		
		treatment.setPetinatId(request.getParameter("patientId"));
		treatment.setDoctorId(request.getParameter("docId"));
		treatment.setTratmentDescription(request.getParameter("description"));
		treatment.setDateOfTreatment(request.getParameter("tratmentDate"));

		
		System.out.println("test");
		iTreatmentService treatmentService = new TreatmentServiceImpl();
		treatmentService.addTreatment(treatment);
		System.out.println("test 1");
		request.setAttribute("treatment", treatment);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doctorDashbord.jsp");
		dispatcher.forward(request, response);
	}
		
		
	}


