<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<meta name="keywords" content="HOSPITAL,HOSPITAL.COM,HOSPITAL WEBSITE, MEDICAN">
	<meta name="description" content="india's best hospital website of indian">
	<meta name="author" content="hospital.com">
	  <style><%@include file="/static/css/index.css"%></style>
	<style><%@include file="/static/css/fontawesome/css/all.css"%></style>
	
<title>Doctor Details Page</title>
<style type="text/css">
  	.hoverTable{
		width:100%; 
		border-collapse:collapse; 
	}
	.hoverTable td{ 
		padding:7px; border:#4e95f4 1px solid;
	}
	/* Define the default color for all the table rows */
	.hoverTable tr{
		background: #b8d1f3;
	}
	/* Define the hover highlight color for the table row */
    .hoverTable tr:hover {
          background-color: #ffff99;
    }
    
body {
  background-image: url('static/images/hospital.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}
   </style>

</head>
<body>
<%
String label = (String)session.getAttribute("label");
if(label==null){
	response.sendRedirect("DoctorLogin.jsp");
}
%>

   <div align="center">
   <table border="1" class="hoverTable" >
	    <tr align="center" >   
	    <th>Doctor Name</th>
	    <th>Doctor Speciality</th>
	    <th>Doctor Clinic</th>
	    <th>Doctor Number</th>
	    <th> Area</th>
	    <th>Doctor Building</th>
	    <th>Doctor Road</th>
	    <th>Doctor Pin</th>
	  </tr>
     <tr>
      <td>${doctor.name}</td>
      <td>${doctor.specialist}</td>
      <td>${doctor.clinic}</td>
      <td>${doctor.phone}</td>
      <td>${doctor.area}</td>
      <td>${doctor.building}</td>
      <td>${doctor.road}</td>
      <td>${doctor.pin}</td>
     </tr>
   </table>
  </div>
</body>
</html>