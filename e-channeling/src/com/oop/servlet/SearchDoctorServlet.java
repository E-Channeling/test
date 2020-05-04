package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class SearchDoctorServlet
 */
@WebServlet("/SearchDoctorServle")
public class SearchDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		DoctorService doctorService = new DoctorServiceImpl();
		ArrayList<Doctor> docArrayList = new ArrayList<Doctor>();
		
		docArrayList = doctorService.findByName(request.getParameter("search"));
		request.setAttribute("docArrayList", docArrayList);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doctorSearchResult.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
