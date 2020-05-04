package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.Enum.AppoimentStatus;
import com.oop.service.AppoimentService;
import com.oop.service.Impl.AppoimentServiceImpl;

/**
 * Servlet implementation class ApproveRejectServlet
 */
@WebServlet("/ApproveRejectServle")
public class ApproveRejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveRejectServlet() {
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
		
		String approve = request.getParameter("approve");
		String reject = request.getParameter("reject");
		
		if(approve != null) {
			AppoimentService appoimentService = new AppoimentServiceImpl();
			appoimentService.updateStatus(Long.parseLong(request.getParameter("appoimentId")), AppoimentStatus.APPROVE.toString());
		}
		else if(reject != null) {
			AppoimentService appoimentService = new AppoimentServiceImpl();
			appoimentService.updateStatus(Long.parseLong(request.getParameter("appoimentId")), AppoimentStatus.REJECT.toString());
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/approveReject.jsp");
		dispatcher.forward(request, response);
	}

}
