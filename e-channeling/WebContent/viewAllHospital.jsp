 <%
    response.setHeader("Cache-Controle", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setHeader("Expires", "0"); //Proxiy
    session.getAttribute("id");
           if(session.getAttribute("email") == null)
               response.sendRedirect("adminLogin.jsp");
    %>
<%@page import="com.oop.Enum.AppoimentStatus"%>
<%@page import="com.oop.model.Hospital"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.Impl.HospitalServiceImpl"%>
<%@page import="com.oop.service.HospitalService"%>


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
		try{
			ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();
			HospitalService hospitalService = new HospitalServiceImpl();
			hospitalList = hospitalService.findAll();
			
			if(!hospitalList.isEmpty()) {
				 for(Hospital hospital : hospitalList){
					

	%>
		
	
		  <form method="post" action="HospitalMangeServlet" class="form">
        	<table>
        		<tr>
        			<th>Hospital Name</th>
        			<th>Address</th>
        			<th>Contact No</th>
        			<th></th>
        			<th></th>
        		</tr>
        		<tr>
        			<td><%=hospital.getName() %></td>
        			<td><%=hospital.getAddress() %></td>
        			<td><%=hospital.getContact() %></td>

        		<input type="radio" name="hospitalId" value="<%=hospital.getId()%>" checked="checked" style="visibility: hidden;">
            	<%if(!hospitalList.isEmpty()) {
            		out.print("<td><input class='btn btn-lg btn-success btn-block' type='submit' value='update' name='update'></td>");
            		out.print("<td><input class='btn btn-lg btn-danger btn-block' type='submit' value='delete' name='delete'></td>");
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
		}catch (Exception e) {
			
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