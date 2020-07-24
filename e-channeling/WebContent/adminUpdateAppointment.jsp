<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="com.oop.model.Appoiment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.Impl.AppoimentServiceImpl"%>
<%@page import="com.oop.service.AppoimentService"%>
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
    	ArrayList<Appoiment> appointmentList = new ArrayList<Appoiment>();
    	appointmentList = (ArrayList<Appoiment>) request.getAttribute("appointmentList");
    %>

        <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5 pt-5">
    	<h3>Update Doctor Details</h3>
        <form method="post" action="AdminUpdateAppointmentServlet" class="form-signin form">
			    <label for="">Appointment Date</label>
			    <input class="form-control" type="text" name="appdate" id="" required="required" value="<%=appointmentList.get(0).getAppoimentDate()%>"> 
			    <label for="">Status</label>
			    <input class="form-control" type="text" name="appstatus" id="" required="required" value="<%=appointmentList.get(0).getStatus()%>"></br>
			    <input type="radio" name="appointmentId" value="<%=appointmentList.get(0).getId()%>" checked="checked" style="visibility: hidden;">
				<input class="btn btn-lg btn-primary btn-block" type="submit" value="Update">
		</form>
	</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>