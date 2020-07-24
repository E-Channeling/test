<%@page import="com.oop.service.DoctorService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.oop.model.Specilization"%>
<%@page import="com.oop.model.Patient"%>
<%@page import="com.oop.model.Appoiment"%>
<%@page import="com.oop.model.Hospital"%>
<%@page import="com.oop.model.Doctor"%>
<%@page import="com.oop.service.Impl.SpecilizationServiceImpl"%>
<%@page import="com.oop.service.Impl.PatientServiceImpl"%>
<%@page import="com.oop.service.Impl.AppoimentServiceImpl"%>
<%@page import="com.oop.service.Impl.DoctorServiceImpl"%>
<%@page import="com.oop.service.Impl.HospitalServiceImpl"%>
<%@page import="com.oop.service.SpecilizationService"%>
<%@page import="com.oop.service.DoctorService"%>
<%@page import="com.oop.service.PatientService"%>
<%@page import="com.oop.service.HospitalService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
 <%
    response.setHeader("Cache-Controle", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setHeader("Expires", "0"); //Proxiy
    session.getAttribute("id");
           if(session.getAttribute("email") == null)
               response.sendRedirect("adminLogin.jsp");
    %>
<!doctype html>
<html lang="en">
  <head>
  	<title>Sidebar 09</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="css/style.css">	
  </head>
  <body style="background-image: url(images/hero.jpg);">
    <jsp:include page="/WEB-INF/views/header3.jsp"></jsp:include>
	<%
		int patientCount = 0;
		int doctorCount = 0;
		int hospitalCount = 0;
		int categoryCount = 0;
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		 LocalDateTime now = LocalDateTime.now();  
		  
		
		PatientService patientService = new PatientServiceImpl();
		DoctorService doctorService =  new DoctorServiceImpl();
		HospitalService hospitalService =  new HospitalServiceImpl();
		SpecilizationService specilizationService = new SpecilizationServiceImpl();
		
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();
		ArrayList<Specilization> specilizationList = new ArrayList<Specilization>();
		
		patientList = patientService.getPatient();
		if(!patientList.isEmpty())
			patientCount = patientList.size();
		
		doctorList = doctorService.findAll();
		if(!doctorList.isEmpty())
			doctorCount = doctorList.size();
		
		hospitalList = hospitalService.findAll();
		if(!hospitalList.isEmpty())
			hospitalCount = hospitalList.size();
		
		specilizationList = specilizationService.findAll();
		if(!specilizationList.isEmpty())
			categoryCount = specilizationList.size();
	%>
        <!-- Page Content  -->
      <div id="content" class="p-4 p-md-5 pt-5">
        <div class="card-deck">
          <div class="card">
            <img class="card-img-top" src="images/testimonial-bg1.jpg" alt="Card image cap">
            <center>
            <div class="card-body">
              <h5 class="card-title">Number of Doctors</h5>
              <h3 class="card-text"><%out.print(doctorCount); %></h3>
            </div>
            </center>
            <div class="card-footer">
              <small class="text-muted">Last updated <%out.println(dtf.format(now)); %></small>
            </div>
          </div>
          <div class="card">
            <img class="card-img-top" src="images/hospitals1.jpg" alt="Card image cap">
            <center>
            <div class="card-body">
              <h5 class="card-title">Number of Hospitals</h5>
              <h3 class="card-text"><%out.print(hospitalCount); %></h3>
            </div>
            </center>
            <div class="card-footer">
              <small class="text-muted">Last updated <%out.println(dtf.format(now)); %></small>
            </div>
          </div>
          <div class="card">
            <img class="card-img-top" src="images/types1.jpg" alt="Card image cap">
            <center>
            <div class="card-body">
              <h5 class="card-title">Number of Category</h5>
              <h3 class="card-text"><%out.print(categoryCount); %></h3>
            </div>
            </center>
            <div class="card-footer">
              <small class="text-muted">Last updated <%out.println(dtf.format(now)); %></small>
            </div>
          </div>
        </div>
      </br>
      <div class="card-deck">
        <div class="card">
          <img class="card-img-top" src="images/RadAbd-861.jpg" alt="Card image cap">
          <center>
          <div class="card-body">
            <h5 class="card-title">Number of Registed Patient</h5>
            <h3 class="card-text"><%out.print(patientCount); %></h3>
          </div>
          </center>
          <div class="card-footer">
            <small class="text-muted">Last updated <%out.println(dtf.format(now)); %></small>
          </div>
        </div>
        <div class="card">
          <!-- img class="card-img-top" src="..." alt="Card image cap"-->
          <div class="card-body">
            <h5 class="card-title"></h5>
            <p class="card-text"></p>
          </div>
          <div class="card-footer">
            <small class="text-muted"></small>
          </div>
        </div>
        <div class="card">
          <!-- img class="card-img-top" src="..." alt="Card image cap"-->
          <div class="card-body">
            <h5 class="card-title"></h5>
            <p class="card-text"></p>
          </div>
          <div class="card-footer">
            <small class="text-muted"></small>
          </div>
        </div>
      </div>
      </div>
	</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>