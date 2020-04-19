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
 * Servlet implementation class CheckServletForBookings
 */
@WebServlet("/CheckDoctorForBookingServlet")
public class CheckDoctorForBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public String email;
	public String category;
	public String hospital;
    public CheckDoctorForBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Booking booking = new Booking();
		
		
		booking.setEmail(request.getParameter("patientId"));
		booking.setCategory(request.getParameter("category"));
		booking.setHospital(request.getParameter("hospital"));
		email = request.getParameter("patientId");
		category = request.getParameter("category");
		hospital = request.getParameter("hospital");
		request.setAttribute("email",email);
		request.setAttribute("category",category);
		request.setAttribute("hospital",hospital);
		
//		System.out.println("test");
//		iBookService bookService = new BookServiceImpl();
//		bookService.addBooking(booking);
//		System.out.println("test 1");
//		request.setAttribute("booking", booking);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bookingDoctor.jsp");
		dispatcher.forward(request, response);
	}

}
