<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
  background-image: url('static/images/hospital.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}</style>
</head>
<body>
<%
String label=(String)session.getAttribute("label");
if(label==null){
	response.sendRedirect("LoginPatient.jsp");
}
%>
<div align="center">
<form action="changePassword" >
enter your current password<input type="password" name="pass"><br>
<input type="submit" style="background:red; font-size: 16px; cursor:pointer">
</form>
</div>
</body>
</html>
