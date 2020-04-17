<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FeedBack</title>
</head>
<body>
<h1>FeedBack page</h1>
<form method="post" action = "AddFeedBackServlet">
 patientid <input type="text" name="patientId" >
  doctorid <input type="text" name="docId" >
   description <input type="text" name="description" >
   date <input type="text" name="tratmentDate" >
   <input type="submit">
  </form>
</body>
</html>