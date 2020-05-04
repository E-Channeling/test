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
import javax.servlet.http.HttpSession;

import com.oop.model.Doctor;
import com.oop.service.DoctorService;
import com.oop.service.PatientService;
import com.oop.service.Impl.DoctorServiceImpl;
import com.oop.service.Impl.PatientServiceImpl;

/**
 * Servlet implementation class LoginDoctorServlet
 */
@WebServlet("/LoginDoctorServle")
public class LoginDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDoctorServlet() {
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
		
		String userID = request.getParameter("userID");
		String password = getMd5(request.getParameter("password"));
		String err = "Incorect email or password";
		
		DoctorService doctorService = new DoctorServiceImpl();
		
		
		
		if(doctorService.loginValidate(userID, password)) {
			ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
			DoctorService doctortSer = new DoctorServiceImpl();
			doctorList = doctortSer.findByUserId(request.getParameter("userID"));
			
			HttpSession session = request.getSession();
			session.setAttribute("email", userID);
			session.setAttribute("id", doctorList.get(0).getId());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doctorDashbord.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("error", err);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doctorLogin.jsp");
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
