<%@page import="com.test.model.Patient"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.serviceImpl.PatientServiceImpl"%>
<%@page import="com.test.service.PatientService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient list</title>
</head>
<body>

	  <div align="left">
		<table border="1" cellpadding="12">
		 <caption><h2>List of patient</h2></caption>
		 <a href="doctorDashbord.jsp">back</a>
		  <tr>
                <th>patient ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                <th>Mobile No</th>
                <th>Address</th>
                <th>Email</th>
                <th>Select</th>
            </tr>
            <%
            PatientService iPatientService = new PatientServiceImpl();
			ArrayList<Patient> arrayList = iPatientService.getPatient();
			
			for(Patient patient : arrayList){
			%>
			 <tr>
				<td> <%=patient.getfName() %> </td>
				<td> <%=patient.getlName() %> </td>
				<td> <%=patient.getPassword() %> </td>
				<td> <%=patient.getEmail() %> </td>
				<td> <%=patient.getDOB() %> </td>
				<td> <%=patient.getGender() %> </td>
				<td> <%=patient.getAddress() %> </td>
				<td> <%=patient.getPhoneNo() %> </td>	
				<td><a href="#treatmentHistory">>veiw Treatment History</a> </td>	
				</tr>			
			<%	
			   }
            %>     
		</table>
		</div>
		

		
		
		



</body>
</html>