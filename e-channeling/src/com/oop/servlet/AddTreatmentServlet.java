package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.Enum.AppoimentStatus;
import com.oop.model.Treatment;
import com.oop.service.AppoimentService;
import com.oop.service.TreatmentService;
import com.oop.service.Impl.AppoimentServiceImpl;
import com.oop.service.Impl.TreatmentServiceImpl;

/**
 * Servlet implementation class AddTreatmentServlet
 */
@WebServlet("/AddTreatmentServle")
public class AddTreatmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTreatmentServlet() {
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
		Treatment treatment = new Treatment();
		
		treatment.setPatientId(request.getParameter("patient"));
		treatment.setDoctorId(request.getParameter("id"));
		treatment.setDescription(request.getParameter("desc"));
		
		TreatmentService treatmentService = new TreatmentServiceImpl();
		treatmentService.addTreatmentDetails(treatment);
		AppoimentService appoimentService = new AppoimentServiceImpl();
		appoimentService.updateStatusByScheduleId(Long.parseLong(request.getParameter("schedule")), AppoimentStatus.COMPLETE.toString());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addTreatment.jsp");
		dispatcher.forward(request, response);
	}

}
