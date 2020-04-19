package com.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.Booking;
import com.test.service.iBookService;
import com.test.serviceImpl.BookServiceImpl;


/**
 * Servlet implementation class AddBookingServlet
 */
@WebServlet("/AddBookingServlet")
public class AddBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookingServlet() {
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
		Booking booking = new Booking();
	
		
		booking.setEmail(request.getParameter("email"));
		booking.setCategory(request.getParameter("category"));
		booking.setHospital(request.getParameter("hospital"));
		booking.setPatientId(request.getParameter("patientId"));
		booking.setDoctorId(request.getParameter("doctorName"));
		booking.setDoctorName(request.getParameter("docId"));
		booking.setBookingDate(request.getParameter("date"));
		booking.setDescription(request.getParameter("description"));
		
		
		System.out.println("test");
		iBookService bookService = new BookServiceImpl();
		bookService.addBooking(booking);
		System.out.println("test 1");
		request.setAttribute("booking", booking);
		

		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/patientDashbord.jsp");
		dispatcher.forward(request, response);
	}

}
