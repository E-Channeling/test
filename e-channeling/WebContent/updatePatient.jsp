<%@page import="com.oop.model.Patient"%>
<%@page import="com.oop.service.Impl.PatientServiceImpl"%>
<%@page import="com.oop.service.PatientService"%>
<%@page import="java.util.ArrayList"%>
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
    <%
	    String id = session.getAttribute("id").toString();
	    PatientService patientService = new PatientServiceImpl();
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		patientList = patientService.getPatientByID(id);
    %>
        <form method="post" target="_self" class="form"
					action="UpdatePatientServlet">
					<h1>Profile Update</h1>
					<div class="form-group">
					<label>First Name</label> 
					<input type="text" class="form-control"
						value="<%=patientList.get(0).getFirstName()%>" required autofocus name="fName">
					<label>Last Name</label> 
					<input type="text" class="form-control"
						value="<%=patientList.get(0).getLastName()%>" required autofocus name="lName"> 
					<label>Phone Number</label> 
					<input type="number" class="form-control" placeholder="<%=patientList.get(0).getContact()%>"
						required autofocus name="phoneNo"> 
					<label>Address</label>
					<input type="text" class="form-control" value="<%=patientList.get(0).getAddress()%>"
						required autofocus name="address"> 
					<label>Email address</label> 
					<input type="email" class="form-control"
						value="<%=patientList.get(0).getEmail()%>" required autofocus name="email"> </br> 
					<input type="radio" name="id" value="${id}" checked="checked" style="visibility: hidden;">
					<button class="btn btn-lg btn-primary btn-block" type="submit" id="btnSubmit">Update</button>
					</div>
				</form>
	</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>