<%@page import="org.apache.taglibs.standard.tag.common.core.CatchTag"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.model.Schedule"%>
<%@page import="com.oop.model.Patient"%>
<%@page import="com.oop.model.Appoiment"%>
<%@page import="com.oop.service.Impl.ScheduleServiceImpl"%>
<%@page import="com.oop.service.Impl.PatientServiceImpl"%>
<%@page import="com.oop.service.Impl.AppoimentServiceImpl"%>
<%@page import="com.oop.service.ScheduleService"%>
<%@page import="com.oop.service.PatientService"%>
<%@page import="com.oop.service.AppoimentService"%>
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
		table{
    		width: 100%;
		}
    </style>
  </head>
  <body style="background-image: url(images/hero.jpg);">
    <jsp:include page="/WEB-INF/views/header2.jsp"></jsp:include>

        <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5 pt-5">
    <%
    	try {
	    	String id = session.getAttribute("id").toString();
	    	ScheduleService scheduleService = new ScheduleServiceImpl();
	    	ArrayList<Schedule> sheduleList = new ArrayList<Schedule>();
	    	
	    	
	    	
		    	sheduleList = scheduleService.getAllPendingApproval(Long.parseLong(id));
		    	if(!sheduleList.isEmpty()) {
		    		for(Schedule schedule : sheduleList) {
		    			ArrayList<Appoiment> appoimentList = new ArrayList<Appoiment>();
		    			AppoimentService appoimentService = new AppoimentServiceImpl();
		    			appoimentList = appoimentService.getAppoimetByScheduleId(Long.parseLong(schedule.getId()));
		    			
		    			if(!appoimentList.isEmpty()) {
		    				PatientService patientService = new PatientServiceImpl();
		    	    		ArrayList<Patient> patientList = new ArrayList<Patient>();
		    	    		patientList = patientService.getPatientByID(appoimentList.get(0).getPatientId());
    	
    %>
        <form method="post" action="ApproveRejectServlet" class="form">
        	<table>
        		<tr>
        			<th>Patient Name</th>
        			<th>Gender</th>
        			<th>DOB</th>
        			<th>Contact Number</th>
        			<th>Date</th>
        			<th>From</th>
        			<th>To</th>
        			<th>Status</th>
        			<th></th>
        			<th></th>
        		</tr>
        		<tr>
        			<td><%=patientList.get(0).getFirstName() + " " + patientList.get(0).getLastName() %></td>
        			<td><%=patientList.get(0).getGender() %></td>
        			<td><%=patientList.get(0).getDob() %></td>
        			<td><%=patientList.get(0).getContact() %></td>
        			<td><%=schedule.getDate() %></td>
        			<td><%=schedule.getFromTime() %></td>
        			<td><%=schedule.getToTime() %></td>
        			<td><%=appoimentList.get(0).getStatus() %></td>
        			
        			
        		
        		<input type="radio" name="id" value="${id}" checked="checked" style="visibility: hidden;">
        		<input type="radio" name="appoimentId" value="<%=appoimentList.get(0).getId()%>" checked="checked" style="visibility: hidden;">
            	<%if(!appoimentList.isEmpty()) {
            		out.print("<td><input class='btn btn-lg btn-success btn-block' type='submit' value='Approve' name='approve'></td>");
            		out.print("<td><input class='btn btn-lg btn-danger btn-block' type='submit' value='Reject' name='reject'></td>");
            	} else {
            		out.print("<h3>No Approve Request</h3>");
            	}
            	%>
            	</tr>
        	</table>
        </form>
    <%
    			}
    		}
    	}
    	}catch(Exception e) {
    		
    	}
    %>
	</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>