 <%
    response.setHeader("Cache-Controle", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setHeader("Expires", "0"); //Proxiy
    session.getAttribute("id");
           if(session.getAttribute("email") == null)
               response.sendRedirect("adminLogin.jsp");
    %>
    
<%@page import="com.oop.model.Appoiment"%>
<%@page import="com.oop.model.Patient"%>
<%@page import="com.oop.model.Schedule"%>
<%@page import="com.oop.model.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.Impl.AppoimentServiceImpl"%>
<%@page import="com.oop.service.Impl.PatientServiceImpl"%>
<%@page import="com.oop.service.Impl.ScheduleServiceImpl"%>
<%@page import="com.oop.service.Impl.DoctorServiceImpl"%>
<%@page import="com.oop.service.AppoimentService"%>
<%@page import="com.oop.service.PatientService"%>
<%@page import="com.oop.service.ScheduleService"%>
<%@page import="com.oop.service.DoctorService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
			
			padding: 10px;
		}
		th{
			background-color: blue;
			color:white;
			padding: 5px;
			opacity: 1;
		}
	</style>
  </head>
  <body style="background-image: url(images/hero.jpg);">
    <jsp:include page="/WEB-INF/views/header3.jsp"></jsp:include>
    
            <!-- Page Content  -->
      <div id="content" class="p-4 p-md-5 pt-5">
      
      <% 
      	String id = session.getAttribute("id").toString();
      %>
      
      <form method="post" action="AdminPasswordChangeServlet" class = "form">
      	<h1>Change Password</h1>
      	<div class = "form-group">
      	<label>Current Password</label>
      	<input type = "password" name = "current_password" class = form-control>
      	<label>New Password</label>
      	<input type = "password" name = "new_password" class = form-control>
      	<label>Confirm New Password</label>
      	<input type = "password" name = "confirm_password" class = form-control></br>
      	<input type="radio" name="id" value="${id}" checked="checked" style="visibility: hidden;">
      	<button class="btn btn-lg btn-primary btn-block" type="submit" id="btnSubmit">Change</button>
      	</div>
      </form>
      
	</div>
	</body>
	<script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
</html>