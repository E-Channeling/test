<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
    response.setHeader("Cache-Controle", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setHeader("Expires", "0"); //Proxiy
    session.getAttribute("id");
           if(session.getAttribute("email") == null)
               response.sendRedirect("doctorLogin.jsp");
    %>

<%@page import="com.oop.model.Specilization"%>
<%@page import="com.oop.model.Schedule"%>
<%@page import="com.oop.model.Doctor"%>
<%@page import="com.oop.model.Hospital"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.Impl.SpecilizationServiceImpl"%>
<%@page import="com.oop.service.Impl.DoctorServiceImpl"%>
<%@page import="com.oop.service.Impl.HospitalServiceImpl"%>
<%@page import="com.oop.service.Impl.ScheduleServiceImpl"%>
<%@page import="com.oop.service.SpecilizationService"%>
<%@page import="com.oop.service.HospitalService"%>
<%@page import="com.oop.service.DoctorService"%>
<%@page import="com.oop.service.ScheduleService"%>
<!doctype html>
<html lang="en">
  <head>
  	<title>Update</title>
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
			background-color: yellow;
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
    <jsp:include page="/WEB-INF/views/header2.jsp"></jsp:include>

        <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5 pt-5">
    
    	<table>
		<tr>
			<th>Hospital</th>
			<th>Category</th>
			<th>From</th>
			<th>To</th>
			<th>Date</th>
			<th>Status</th>
			<th></th>
			<th></th>
		</tr>
        <%
         try{
        	String id = session.getAttribute("id").toString();
			ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();
        	ScheduleService scheduleService = new ScheduleServiceImpl();
        	scheduleList = scheduleService.getAllAvailableSchedule(Long.parseLong(id));
		
			if(!scheduleList.isEmpty()) {
				for(Schedule schedule : scheduleList) {
					HospitalService hospitalService = new HospitalServiceImpl();
					ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();
					SpecilizationService specilizationService = new SpecilizationServiceImpl();
					ArrayList<Specilization> specilizationList = new ArrayList<Specilization>();
					
					hospitalList = hospitalService.findById(Long.parseLong(schedule.getHospitalId()));
					specilizationList = specilizationService.findById(Long.parseLong(schedule.getSpecilizationId()));
			%>
	
		<tr>
			<td><%=hospitalList.get(0).getName() %></td>
			<td><%=specilizationList.get(0).getSpecName() %></td>
			<td><%=schedule.getFromTime() %></td>
			<td><%=schedule.getToTime() %></td>
			<td><%=schedule.getDate() %></td>
			<td><%=schedule.getStatus() %></td>
			<form action="UpdateScheduleServlet" method="post">
				<input type="radio" name="scheduleId" value="<%=schedule.getId()%>" checked="checked" style="visibility: hidden;">
				<td><input class='btn btn-lg btn-success btn-block' type='submit' value='Update' name='update'></td>
				<td><input class='btn btn-lg btn-danger btn-block' type='submit' value='Delete' name='delete'></td>
			</form>
			
				
		</tr>
		<%
				}
			}
         } catch (Exception e) {
        	 
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