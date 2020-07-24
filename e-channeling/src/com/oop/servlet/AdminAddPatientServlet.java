package com.oop.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.oop.model.Patient;
import com.oop.service.PatientService;
import com.oop.service.Impl.PatientServiceImpl;

/**
 * Servlet implementation class AdminAddPatientServlet
 */
@WebServlet("/AdminAddPatientServle")
public class AdminAddPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddPatientServlet() {
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
		Patient patient = new Patient();
		ArrayList<Patient> patientArrayList = new ArrayList<Patient>();
		PatientService patientService = new PatientServiceImpl();
		patientArrayList = patientService.findByUserId(request.getParameter("userID"));
		
		if(patientArrayList.isEmpty()) {
		
			patient.setFirstName(request.getParameter("fName"));
			patient.setLastName(request.getParameter("lName"));
			patient.setDob(request.getParameter("DOB"));
			patient.setContact(request.getParameter("phoneNo"));
			patient.setAddress(request.getParameter("pAddress"));
			patient.setGender(request.getParameter("gender"));
			patient.setEmail(request.getParameter("email"));
			patient.setUser_id(request.getParameter("userID"));
			patient.setPassword(getMd5(request.getParameter("password")));
			
			InputStream inputStream = null;;
			patientService.addPatient(patient, inputStream);

			request.setAttribute("patient", patient);
		
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminDashbord.jsp");
			dispatcher.forward(request, response);
		}
		else {
			String msg = "User ID alredy exist";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminAddPatient.jsp");
			dispatcher.forward(request, response);
		}
		
	}
	
	public static String getMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
	}

}
