package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Schedule;
import com.oop.service.ScheduleService;
import com.oop.service.Impl.ScheduleServiceImpl;

/**
 * Servlet implementation class UpdateScheduleServlet
 */
@WebServlet("/UpdateScheduleServle")
public class UpdateScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateScheduleServlet() {
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
			ScheduleService scheduleService = new ScheduleServiceImpl();
			ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();
			scheduleList = scheduleService.findById(Long.parseLong(request.getParameter("scheduleId")));
			request.setAttribute("scheduleList", scheduleList);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateScheduleDetails.jsp");
			dispatcher.forward(request, response);
		}
		else if(delete != null) {
			ScheduleService scheduleService = new ScheduleServiceImpl();
			scheduleService.removeSchedule(Long.parseLong(request.getParameter("scheduleId")));
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateSchedule.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
