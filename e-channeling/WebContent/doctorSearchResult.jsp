<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.model.Doctor"%>
<%@page import="com.oop.model.Specilization"%>
<%@page import="com.oop.model.DoctorSpeclization"%>
<%@page import="com.oop.service.DoctorSpeclizationService"%>
<%@page import="com.oop.service.SpecilizationService"%>
<%@page import="com.oop.service.Impl.SpecilizationServiceImpl"%>
<%@page import="com.oop.service.Impl.DoctorSpeclizationServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		table{
			background-color: white;
    		box-shadow: 2px 2px 2px 2px rgb(194, 194, 194);
    		opacity: 0.8;
    		width: 100%;
    		padding: 10px;
		}
		table:hover{
			opacity: 0.9;
		}
		td{
			margin: 8%;
			padding: 10px;
		}
		tr{
			
		}
		tr:hover{
			background-color: red;
			padding: 10px;
		}
		th{
			background-color: green;
			padding: 5px;
			opacity: 1;
		}
	</style>
  </head>
  <body style="background-image: url(images/hero.jpg);">
    <jsp:include page="/WEB-INF/views/header1.jsp"></jsp:include>

        <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5 pt-5">
    
    	<table>
		<tr>
			<th>Name</th>
			<th>Contact No</th>
			<th>Email</th>
			<th>Specialization</th>
			<th>Hospital</th>
		</tr>
        <%
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		doctorList = (ArrayList<Doctor>) request.getAttribute("docArrayList");
		
		for(Doctor doctor : doctorList) {
			ArrayList<DoctorSpeclization> doctorSpeclizationList = new ArrayList<DoctorSpeclization>();
			DoctorSpeclizationService doctorSpeclizationService = new DoctorSpeclizationServiceImpl();
			if(!doctorList.isEmpty())
				doctorSpeclizationList = doctorSpeclizationService.findByDoctorId(Long.parseLong(doctor.getId()));
			SpecilizationService specilizationService = new SpecilizationServiceImpl();
			ArrayList<Specilization> specilizationList = new ArrayList<Specilization>();
			if(!doctorSpeclizationList.isEmpty()) 
				specilizationList = specilizationService.findById(Long.parseLong(doctorSpeclizationList.get(0).getSpecilizationId()));
	%>
	
		<tr>
			<td><%=doctor.getFirstName() + " " + doctor.getLastName() %></td>
			<td><%= doctor.getContact() %></td>
			<td><%= doctor.getEmail() %></td>
			<%if(!specilizationList.isEmpty()){ %>
			<td><%= specilizationList.get(0).getSpecName() %></td>
			<td></td>
			<% }%>
		</tr>
	
	<%
		}
	%>
	</table>
	</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>