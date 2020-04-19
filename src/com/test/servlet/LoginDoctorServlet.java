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
import com.test.serviceImpl.DoctorServiceImpl;

/**
 * Servlet implementation class LoginDoctorServlet
 */
@WebServlet("/LoginDoctorServlet")
public class LoginDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	HttpSession session = request.getSession();
		    session.removeAttribute("email");
		    response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("data set una");
        Doctor doctor = new Doctor();
        doctor.setEmail(email);
        doctor.setPassword(password);

        if (DoctorServiceImpl.login(doctor)) {
        	System.out.println(response);
		    HttpSession session = request.getSession();
		     session.setAttribute("email",email);
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doctorDashbord.jsp");
    		dispatcher.forward(request, response);
    		
		} else {
		    HttpSession session = request.getSession();
		    session.setAttribute("email",email);
		    response.sendRedirect("index.jsp");
		}
	}

}
