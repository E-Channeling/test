<%@page import="com.oop.model.Feedback"%>
<%@page import="com.oop.model.Patient"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.FeedbackService"%>
<%@page import="com.oop.service.PatientService"%>
<%@page import="com.oop.service.Impl.FeedbackServiceImpl"%>
<%@page import="com.oop.service.Impl.PatientServiceImpl"%>
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
			
			background-color: white;
			box-shadow: 2px 2px 2px 2px rgb(194, 194, 194);
			opacity: 0.7;
		}
    	.form:hover {
    		opacity: 0.9;
			transition: background 0.4s ease-in-out;
		}
    </style>
  </head>
  <body style="background-image: url(images/hero.jpg);">
    <jsp:include page="/WEB-INF/views/header2.jsp"></jsp:include>

        <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5 pt-5">
    	 
          
        
        <%
        	try{
        	int i = 1;
	        	String id = session.getAttribute("id").toString();
	        	ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
	        	FeedbackService feedbackService = new FeedbackServiceImpl();
	        	feedbackList = feedbackService.findByDoctorId(Long.parseLong(id));
	        	if(!feedbackList.isEmpty()) {
	        			for(Feedback feedback : feedbackList) {
	        				ArrayList<Patient> patientList = new ArrayList<Patient>();
	        				PatientService patientService = new PatientServiceImpl();
		    	    		patientList = patientService.getPatientByID(feedback.getPatientId());
	        	if(i==1) {
	        		out.println("<div class='card-deck'>");
	        	}
        %>
        <div class="card form">
            <img class="card-img-top" src="" alt="">
            <div class="card-body">
              <h5 class="card-title"><%=patientList.get(0).getFirstName() + " "+ patientList.get(0).getLastName() %></h5>
              <p class="card-text"><%=feedback.getDescription() %></p>
            </div>
            <div class="card-footer">
              <small class="text-muted"><%=feedback.getDate() %></small>
            </div>
          </div>
         <%
         	if(i==3) {
         		out.println("</div></br>");
         		i = 0;
         	}
         i++;
        			}
        	}
        	}catch (Exception e) {
        		
        	}
         %>  
	</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>