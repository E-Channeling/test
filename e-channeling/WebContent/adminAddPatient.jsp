<%@page import="com.oop.model.Hospital"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.HospitalService"%>
<%@page import="com.oop.service.Impl.HospitalServiceImpl"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

        <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5 pt-5">
    	<h3>Add Hospital</h3>
        <form method="post" action="AdminAddPatientServlet" class="form-signin form">
			    <label for="">First Name</label>
			    <input class="form-control" type="text" name="fName" id="" required="required"> 
			    <label for="">Last Name</label>
			    <input class="form-control" type="text" name="lName" id="" required="required"> 
			    <label for="">Date of Birth</label> 
					<input type="date" class="form-control" name="DOB" id="" required="required">
			    <label for="">Gender</label>
			    <select name="gender" class="form-control">
					    <option value="MALE" selected="selected">MALE</option>
					    <option value="FEMALE" >FEMALE</option>
				</select>
				<label for="">Contact No</label>
				<input type="number" class="form-control" name="phoneNo" id="" required="required"> 
			    <label for="">Address</label>
			    <input class="form-control" type="text" name="pAddress" id="" required="required"> 
			    <label>Email address</label> 
				<input type="email" class="form-control" name="email" id="" required="required">
					<label>User ID</label> 
					<input type="text" class="form-control" name="userID" id="" required="required"> 
					<label for="inputPassword">Password</label> 
					<input type="password" class="form-control" name="password" id="" required="required">
					<label for="inputPassword">Confirm Password</label> 
					<input type="password"class="form-control" name="cPassword" id="" required="required"></br>
				<input class="btn btn-lg btn-primary btn-block" type="submit">
		</form>
	</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>