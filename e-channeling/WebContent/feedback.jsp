<%@page import="com.oop.model.Doctor"%>
<%@page import="com.oop.service.DoctorService"%>
<%@page import="com.oop.service.Impl.DoctorServiceImpl"%>
<%@page import="java.util.ArrayList"%>
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
    	.form{
    		border-radius: 5px; 
    		padding: 15px;
    		background-color: white;
    		box-shadow: 2px 2px 2px 2px rgb(194, 194, 194);
    		margin: 10px;
    		opacity: 0.8;
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
    	<h3>FeedBack</h3>
        <form action="AddFeedbackServlet" method="post" class="form">
			<label for="">Select Doctor</label>
			<select name="doctor" id="" class="form-control" required="required">
			<%
			DoctorService doctorService = new DoctorServiceImpl();
			ArrayList<Doctor> doctorlList = doctorService.findAll();
						
				for(Doctor doctor : doctorlList){
			%>
				<option value="<%=doctor.getId()%>"><%=doctor.getFirstName() +" " + doctor.getFirstName() %></option>
			<%	
				}
			%> 
			</select></br>
			<label for="">Description</label>
			<textarea name="feedback" id="" cols="30" rows="10" class="form-control" required="required"></textarea>
			<input type="radio" name="id" value="${id}" checked="checked" style="visibility: hidden;">
			<input class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">
		</form>
	</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>