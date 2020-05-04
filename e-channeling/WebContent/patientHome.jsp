<%@page import="com.oop.model.Specilization"%>
<%@page import="com.oop.model.Doctor"%>
<%@page import="com.oop.model.Hospital"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.Impl.SpecilizationServiceImpl"%>
<%@page import="com.oop.service.Impl.DoctorServiceImpl"%>
<%@page import="com.oop.service.Impl.HospitalServiceImpl"%>
<%@page import="com.oop.service.SpecilizationService"%>
<%@page import="com.oop.service.HospitalService"%>
<%@page import="com.oop.service.DoctorService"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
    response.setHeader("Cache-Controle", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setHeader("Expires", "0"); //Proxiy
    session.getAttribute("id");
           if(session.getAttribute("email") == null)
               response.sendRedirect("patientLogin.jsp");
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
	<style type="text/css">
    	.form{
			border-radius: 10px; 
			padding: 30px;
			background-color: white;
			box-shadow: 2px 2px 2px 2px rgb(194, 194, 194);
			margin: 10px;opacity: 0.7;
		}
    	.form:hover {
    		opacity: 0.9;
			transition: background 0.4s ease-in-out;
		}
    </style>
  </head>
  <body style="background-image: url(images/hero.jpg);">
    <jsp:include page="/WEB-INF/views/header1.jsp"></jsp:include>

        <!-- Page Content  -->
      <div id="content" class="p-4 p-md-5 pt-5">
        <h1>Channel Doctor</h1>
			<form method="post" action="CheckAvailableServlet" class="form-signin form" style="">
				<center>
				<img alt="" src="images/doctors.png" style="margin-right: 8%">
				<img alt="" src="images/specialities.png" style="margin-right: 8%">
				<img alt="" src="images/heart-beat.png" style="margin-right: 8%">
				<img alt="" src="images/stomach.png" style="margin-right: 8%;">
				<img alt="" src="images/blood-sample.png" style="margin-right: 8%;">
				<img alt="" src="images/blood-donation.png" style="margin-right: 8%;">
				</center><br>
				<label for="">Categoty</label>
			    <select name="spz" id="" class="form-control" required="required">
			    <%
			    SpecilizationService specilizationService = new SpecilizationServiceImpl();
					ArrayList<Specilization> arrayList = specilizationService.findAll();
					
					for(Specilization specilization : arrayList){
				%>
				
			        <option value= "<%=specilization.getId()%>"><%=specilization.getSpecName() %></option>
			    <%	
			   		}
            	%>     
			    </select>
			    <label for="">Hospital</label>
			    <select name="hospital" id="" class="form-control" required="required">
			    <%
			    HospitalService hospitalService = new HospitalServiceImpl();
					ArrayList<Hospital> hospitalList = hospitalService.findAll();
					
					for(Hospital hospital : hospitalList){
				%>
			        <option value="<%=hospital.getId()%>"><%=hospital.getName() %></option>
			     <%	
			   		}
            	%> 
			    </select>
			    <label for="">Doctor</label>
			    <select name="doctor" id="" class="form-control" required="required">
			     <%
			    DoctorService doctorService = new DoctorServiceImpl();
					ArrayList<Doctor> doctorlList = doctorService.findAll();
					
					for(Doctor doctor : doctorlList){
				%>
			        <option value="<%=doctor.getId()%>"><%=doctor.getFirstName() +" " + doctor.getFirstName() %></option>
			    <%	
			   }
					/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");  
				    Date date = new Date(); 
				   	request.setAttribute("date", formatter.format(date));
				   	request.getAttribute("date");*/
            %> 
			    </select>
			    <label for="">Date </label>
			    <input class="form-control" min="${date}" type="date" name="date" id="" required="required"> 
			    </br>
			    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Check Available">
			</form>
      </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>