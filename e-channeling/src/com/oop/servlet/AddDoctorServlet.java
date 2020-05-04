package com.oop.servlet;

import java.io.IOException;
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

import com.oop.model.Doctor;
import com.oop.model.Patient;
import com.oop.service.DoctorService;
import com.oop.service.PatientService;
import com.oop.service.Impl.DoctorServiceImpl;
import com.oop.service.Impl.PatientServiceImpl;

/**
 * Servlet implementation class AddDoctorServlet
 */
@WebServlet("/AddDoctorServle")
public class AddDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctorServlet() {
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
		
		Doctor doctor = new Doctor();
		ArrayList<Doctor> doctorArrayList = new ArrayList<Doctor>();
		DoctorService doctorService = new DoctorServiceImpl();
		doctorArrayList = doctorService.findByUserId(request.getParameter("userID"));
		
		if(doctorArrayList.isEmpty()) {
		
			doctor.setFirstName(request.getParameter("fName"));
			doctor.setLastName(request.getParameter("lName"));
			doctor.setContact(request.getParameter("phoneNo"));
			doctor.setAddress(request.getParameter("address"));
			doctor.setGender(request.getParameter("gender"));
			doctor.setEmail(request.getParameter("email"));
			doctor.setHospitalId(request.getParameter("hospital"));
			doctor.setUserId(request.getParameter("userID"));
			doctor.setPassword(getMd5(request.getParameter("password")));
		
			doctorService.addDoctor(doctor);

			request.setAttribute("patient", doctor);
		
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doctorLogin.jsp");
			dispatcher.forward(request, response);
		}
		else {
			String msg = "User ID alredy exist";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doctorRegister.jsp");
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
