<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="com.oop.model.Patient"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.Impl.PatientServiceImpl"%>
<%@page import="com.oop.service.PatientService"%>
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
    <jsp:include page="/WEB-INF/views/header3.jsp"></jsp:include>
    
    <%
    	ArrayList<Patient> patientList = new ArrayList<Patient>();
    	patientList = (ArrayList<Patient>) request.getAttribute("patientList");
    %>

        <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5 pt-5">
    	<h3>Update Patient Details</h3>
        <form method="post" action="AdminUpdatePatientServlet" class="form-signin form">
			    <label for="">First Name</label>
			    <input class="form-control" type="text" name="fName" id="" required="required" value="<%=patientList.get(0).getFirstName()%>"> 
			    <label for="">Last Name</label>
			    <input class="form-control" type="text" name="lName" id="" required="required" value="<%=patientList.get(0).getLastName()%>"> 
			    <label for="">Address</label>
			    <input class="form-control" type="text" name="pAddress" id="" required="required" value="<%=patientList.get(0).getAddress()%>"> 
			    <label for="">Contact No</label>
			    <input class="form-control" type="text" name="pContact" id="" required="required" value="<%=patientList.get(0).getContact()%>">
			    <label for="">E mail</label>
			    <input class="form-control" type="text" name="pmail" id="" required="required" value="<%=patientList.get(0).getEmail()%>"></br>
			    <input type="radio" name="patientId" value="<%=patientList.get(0).getId()%>" checked="checked" style="visibility: hidden;">
				<input class="btn btn-lg btn-primary btn-block" type="submit" value="Update">
		</form>
	</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>