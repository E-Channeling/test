package com.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.FeedBack;
import com.test.model.Treatment;
import com.test.service.iFeedBackService;
import com.test.service.iTreatmentService;
import com.test.serviceImpl.FeedbackServiceImpl;
import com.test.serviceImpl.TreatmentServiceImpl;

/**
 * Servlet implementation class AddFeedBackServlet
 */
@WebServlet("/AddFeedBackServlet")
public class AddFeedBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFeedBackServlet() {
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
			
			FeedBack feedBack = new FeedBack();
			
			feedBack.setPetinatId(request.getParameter("patientId"));
			feedBack.setDoctorId(request.getParameter("docId"));
			feedBack.setFeedBackDescription(request.getParameter("description"));
	
			
			System.out.println("test");
			iFeedBackService feedBackService = new FeedbackServiceImpl();
			feedBackService.addFeedBack(feedBack);
			System.out.println("test 1");
			request.setAttribute("treatment", feedBack);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/patientDashbord.jsp");
			dispatcher.forward(request, response);
	}

}
