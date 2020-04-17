package com.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.model.Doctor;
import com.test.model.Patient;
import com.test.serviceImpl.DoctorServiceImpl;
import com.test.serviceImpl.PatientServiceImpl;

/**
 * Servlet implementation class LoginPatientServlet
 */
@WebServlet("/LoginPatientServlet")
public class LoginPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPatientServlet() {
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
		
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("data set una");
        Patient patient = new Patient();
        patient.setEmail(email);
        patient.setPassword(password);

        if (PatientServiceImpl.login(patient)) {
		    //HttpSession session = request.getSession();
		    // session.setAttribute("username",username);
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/patientDashbord.jsp");
    		dispatcher.forward(request, response);
		} else {
		    HttpSession session = request.getSession();
		    //session.setAttribute("user", username);
		    //response.sendRedirect("login.jsp");
		}
	}

}
