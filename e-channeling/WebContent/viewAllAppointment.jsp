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
<%@page import="com.oop.Enum.AppoimentStatus"%>
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
			color: white;
		}
	</style>
  </head>
  <body style="background-image: url(images/hero.jpg);">
    <jsp:include page="/WEB-INF/views/header2.jsp"></jsp:include>

        <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5 pt-5">
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
        </tr>
    <%
    	
    	
    	try {
    		String id = session.getAttribute("id").toString();
        	ScheduleService scheduleService = new ScheduleServiceImpl();
        	ArrayList<Schedule> sheduleList = new ArrayList<Schedule>();
    	
	    	sheduleList = scheduleService.getAllScheduleByDoctorId(Long.parseLong(id));
	    	if(!sheduleList.isEmpty()) {
	    		for(Schedule schedule : sheduleList) {
	    			ArrayList<Appoiment> appoimentList = new ArrayList<Appoiment>();
	    			AppoimentService appoimentService = new AppoimentServiceImpl();
	    			appoimentList = appoimentService.getAllAppoimetByScheduleId(Long.parseLong(schedule.getId()));
	    			
	    			if(!appoimentList.isEmpty()) {
	    				if(appoimentList.get(0).getStatus().equalsIgnoreCase(AppoimentStatus.CANCEL.toString()))
	    					continue;
	    				PatientService patientService = new PatientServiceImpl();
	    	    		ArrayList<Patient> patientList = new ArrayList<Patient>();
	    	    		patientList = patientService.getPatientByID(appoimentList.get(0).getPatientId());
    	
    %>
        	
        		<tr>
        			<td><%=patientList.get(0).getFirstName() + " " + patientList.get(0).getLastName() %></td>
        			<td><%=patientList.get(0).getGender() %></td>
        			<td><%=patientList.get(0).getDob() %></td>
        			<td><%=patientList.get(0).getContact() %></td>
        			<td><%=schedule.getDate() %></td>
        			<td><%=schedule.getFromTime() %></td>
        			<td><%=schedule.getToTime() %></td>
        			<td><%=appoimentList.get(0).getStatus() %></td>
        		</tr>
        		
        	
    <%
    			}
    		}
    	}
    	}catch(Exception e) {
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