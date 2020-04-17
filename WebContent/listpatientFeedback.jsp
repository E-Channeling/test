<%@page import="com.test.model.FeedBack"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.serviceImpl.FeedbackServiceImpl"%>
<%@page import="com.test.service.iFeedBackService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Feedbacks</title>
</head>
<body>

	  <div align="left">
		<table border="1" cellpadding="12">
		 <caption><h2>Patient Feedbacks</h2></caption>
		 <a href="doctorDashbord.jsp">back</a>
		  <tr>
                <th>patient ID</th>
                <th>Feedback</th>

            </tr>
            <%
            iFeedBackService iFeedBack = new FeedbackServiceImpl();
			ArrayList<FeedBack> arrayList = iFeedBack.getPatient();
			
			for(FeedBack patient : arrayList){
			%>
			 <tr>
				<td> <%=patient.getPetinatId() %> </td>
				<td> <%=patient.getFeedBackDescription() %> </td>
				</tr>			
			<%	
			   }
            %>     
		</table>
		</div>
		

		
		
		



</body>
</html>