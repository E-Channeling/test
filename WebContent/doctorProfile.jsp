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
	  <div align="left">
		<table border="1" cellpadding="12">
		 <caption><h2>List of patient</h2></caption>
		 <a href="doctorDashbord.jsp">back</a>
		  <tr>
                <th>Registation ID</th>
                <th>Name</th>
                <th>Specialized</th>
                <th>Gender</th>
                <th>Hospital</th>
                <th>Contact No</th>
                <th>Email</th>
                <th>Password</th>
            </tr>
            <%
            iDoctorService iPatientService = new DoctorServiceImpl();
			ArrayList<Doctor> arrayList = iPatientService.getCurrentDoctor("test@gmail.com");
			
			for(Doctor doctor : arrayList){
			%>
			 <tr>
				<td> <%=doctor.getDoctorRegID() %> </td>
				<td> <%=doctor.getName() %> </td>
				<td> <%=doctor.getSpecialized() %> </td>
				<td> <%=doctor.getGender() %> </td>
				<td> <%=doctor.getHospital() %> </td>
				<td> <%=doctor.getContactNo() %> </td>
				<td> <%=doctor.getEmail() %> </td>
				<td> <%=doctor.getPassword() %> </td>	
				</tr>			
			<%	
			   }
            %>     
		</table>
		</div>
</body>
</html>