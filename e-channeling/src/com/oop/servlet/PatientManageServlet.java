package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class PatientManageServlet
 */
@WebServlet("/PatientManageServle")
public class PatientManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientManageServlet() {
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
			PatientService patientService = new PatientServiceImpl();
			ArrayList<Patient> patientList = new ArrayList<Patient>();
			patientList = patientService.getPatientByID(request.getParameter("patientId"));
			request.setAttribute("patientList", patientList);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminUpdatePatient.jsp");
			dispatcher.forward(request, response);
		}
		else if(delete != null) {
			PatientService patientService = new PatientServiceImpl();
			patientService.removePatient(Long.parseLong(request.getParameter("patientId")));
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewAllPatients.jsp");
			dispatcher.forward(request, response);
		}
	}

}
