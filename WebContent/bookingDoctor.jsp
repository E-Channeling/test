<%@page import="com.test.model.Doctor"%>
<%@page import="java.util.ArrayList"%>

<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.test.serviceImpl.DoctorServiceImpl"%>
<%@page import="com.test.service.iDoctorService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String email = (String)request.getAttribute("email"); %>
<%String category = (String)request.getAttribute("category"); %>
<%String hospital = (String)request.getAttribute("hospital"); %>

<form method="post" action="AddBookingServlet">
Email <input type="text" name="email" value=${email} readonly ><br>
category <input type="text" name="category" value=${category} readonly ><br>
hospital <input type="text" name="hospital" value=${hospital} readonly ><br>

	<select name="doctorName">
  <%
            iDoctorService iPatientService = new DoctorServiceImpl();
			ArrayList<Doctor> arrayList = iPatientService.getDoctorListForBooking(category,hospital);
			
			for(Doctor doctor : arrayList){
				
	%>
		<option><%=doctor.getName() %></option>
		<input type="hidden" name="docId" value ="<%=doctor.getDoctorRegID() %>">
	<%
			}
	%>
		</select><br>
	Date of Booking<input type="date" name="date"><br>
	description <textarea rows="20" cols="20" name="description">enter what is the reson for channel</textarea>
<input type="submit" value ="Book">
</form>
<h1>Doctor Booking Page</h1>
</body>
</html>