 <%
    response.setHeader("Cache-Controle", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setHeader("Expires", "0"); //Proxiy
    session.getAttribute("id");
           if(session.getAttribute("email") == null)
               response.sendRedirect("patientLogin.jsp");
    %>
<%@page import="com.oop.Enum.AppoimentStatus"%>
<%@page import="com.oop.model.Specilization"%>
<%@page import="com.oop.model.Schedule"%>
<%@page import="com.oop.model.Doctor"%>
<%@page import="com.oop.model.Hospital"%>
<%@page import="com.oop.model.Appoiment"%>
<%@page import="com.oop.model.Schedule"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.Impl.SpecilizationServiceImpl"%>
<%@page import="com.oop.service.Impl.DoctorServiceImpl"%>
<%@page import="com.oop.service.Impl.HospitalServiceImpl"%>
<%@page import="com.oop.service.Impl.AppoimentServiceImpl"%>
<%@page import="com.oop.service.Impl.ScheduleServiceImpl"%>
<%@page import="com.oop.service.SpecilizationService"%>
<%@page import="com.oop.service.HospitalService"%>
<%@page import="com.oop.service.DoctorService"%>
<%@page import="com.oop.service.AppoimentService"%>
<%@page import="com.oop.Enum.AppoimentStatus"%>
<%@page import="com.oop.Enum.ScheduleStatus"%>

<%@page import="com.oop.service.ScheduleService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<th>Category</th>
			<th>Hosptal</th>
			<th>Doctor</th>
			<th>Date</th>
			<th>From</th>
			<th>To</th>
			<th>Booked Date & Time</th>
			<th>Status</th>
		</tr>
		<%
		try{
			String id = session.getAttribute("id").toString();
			ArrayList<Appoiment> appoimentList = new ArrayList<Appoiment>();
			AppoimentService appoimentService = new AppoimentServiceImpl();
			appoimentList = appoimentService.findByPatientId(Long.parseLong(id));
			ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();
			int pending = 0, reject = 0, complete = 0, approve = 0, cancel = 0;
			if(!appoimentList.isEmpty()) {
				 for(Appoiment appoiment : appoimentList){
					 ScheduleService scheduleService = new ScheduleServiceImpl();
					 scheduleList.addAll(scheduleService.findById(Long.parseLong(appoiment.getScheduleId())));
				 }
			
			 int i = 0;
			 for(Schedule schedule :scheduleList){
				 
				 
					 
						 
					 HospitalService hospitalService = new HospitalServiceImpl();
					  DoctorService doctorService = new DoctorServiceImpl();
					   SpecilizationService specilizationService = new SpecilizationServiceImpl();
					   
					  ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();
					  ArrayList<Doctor> doctotList = new ArrayList<Doctor>();
					  ArrayList<Specilization> specilizationList = new ArrayList<Specilization>();
					  
					  
					  hospitalList = hospitalService.findById(Long.parseLong(schedule.getHospitalId()));
					  doctotList = doctorService.findById(Long.parseLong(schedule.getDoctorId()));
					  specilizationList = specilizationService.findById(Long.parseLong(schedule.getSpecilizationId()));
					  
				  
			  
		 
	%>
		
	
		<tr>
			<td><%=specilizationList.get(0).getSpecName()%></td>
			<td><%=hospitalList.get(0).getName()%></td>
			<td>D.r <%=doctotList.get(0).getFirstName() + " " + doctotList.get(0).getLastName()%></td>
			<td><%=schedule.getDate()%></td>
			<td><%=schedule.getFromTime()%></td>
			<td><%=schedule.getToTime()%></td>
			<td><%=appoimentList.get(i).getAppoimentDate()%></td>
			<td><%=appoimentList.get(i).getStatus() %></td>
		</tr>
	

	<%
		i++;
				}
				
			}
		}catch (Exception e) {
			System.out.print(e);
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