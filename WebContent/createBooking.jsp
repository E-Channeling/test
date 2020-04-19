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
	<form method = "POST" action = "CheckDoctorForBookingServlet">
		
		category <select name="category">
            <%
            iDoctorService iDoctorService = new DoctorServiceImpl();
			ArrayList<Doctor> arrayList = iDoctorService.getDoctorcategory();
			
			for(Doctor doctor : arrayList){
			%>
			<option value="<%=doctor.getSpecialized() %>"><%=doctor.getSpecialized() %></option>
			<%
			}
			%>
					</select> 
		Area <select name="hospital">
			 <%
            iDoctorService iDoctorService2 = new DoctorServiceImpl();
			ArrayList<Doctor> arrayList1 = iDoctorService2.getDoctorHospital();
			
			for(Doctor doctor : arrayList1){
			%>
			<option value="<%=doctor.getHospital() %>"><%=doctor.getHospital() %></option>
			<%
			}
			%>
				</select>
				
		<input type="submit" name="submit" value="check"><br>


	
</body>
</html>