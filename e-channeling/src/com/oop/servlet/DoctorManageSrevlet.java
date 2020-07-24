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
 * Servlet implementation class DoctorManageSrevlet
 */
@WebServlet("/DoctorManageSrevle")
public class DoctorManageSrevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorManageSrevlet() {
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
			DoctorService doctorService = new DoctorServiceImpl();
			ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
			doctorList = doctorService.findById(Long.parseLong(request.getParameter("doctorId")));
			request.setAttribute("doctorList", doctorList);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminUpdateDoctor.jsp");
			dispatcher.forward(request, response);
		}
		else if(delete != null) {
			DoctorService doctorService = new DoctorServiceImpl();
			doctorService.deleteDoctor(Long.parseLong(request.getParameter("doctorId")));
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewAllDcotors.jsp");
			dispatcher.forward(request, response);
		}
	}

}
