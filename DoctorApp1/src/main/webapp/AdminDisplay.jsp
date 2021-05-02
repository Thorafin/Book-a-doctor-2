<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"><meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<meta name="keywords" content="HOSPITAL,HOSPITAL.COM,HOSPITAL WEBSITE, MEDICAN">
	<meta name="description" content="india's best hospital website of indian">
	<meta name="author" content="hospital.com">
	  <style><%@include file="/static/css/index.css"%></style>
	<style><%@include file="/static/css/fontawesome/css/all.css"%></style>
	
<title>Admin Display</title>
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
String label=(String)session.getAttribute("label");
if(label==null){
	response.sendRedirect("AdminPage.jsp");
}
%>
<div align="right">
    <form action="logoutadmin">
    <input type="submit" value="logout" style="background:red; font-size: 16px; cursor:pointer">
    </form>
  </div>
<form action="patientList" method="get">
 <input type="submit" value="Patient" style="background:red; font-size: 16px; cursor:pointer">
</form>
<form action="doctorList">
 <input type="submit" value="Doctor" style="background:red; font-size: 16px; cursor:pointer">
</form>
<div align="center">
<c:choose>
  <c:when test="${not empty appointments}">
  <table border="1" class="hoverTable" >
    <tr align="center" >
    <th>Appointment Id</th>
    <th>Doctor Id</th>
    <th>Customer ID</th>
    <th>Appointment Date</th>
    <th>Appointment Time</th>
    <th>View Doctor</th>
    <th>View Patient</th>
  </tr>
  <c:forEach items="${appointments}" var="appointment" >
   <tr align="center" >
    <td>${appointment.aid}</td>
    <td>${appointment.doctorid}</td>
    <td>${appointment.patientid} </td>
    <td>${appointment.date}</td>
    <td>${appointment.time}</td>
    <td> 
     <form action="ViewDoctor">
    <input type="hidden" name="doctorId" value="${appointment.doctorid}">
    <input type="submit" value="DoctorDetails" style="background:red; font-size: 16px; cursor:pointer">
    </form></td>
    <td>    
    <form action="ViewPatients">
    <input type="hidden" name="PatientId" value="${appointment.patientid}">
    <input type="submit" value="DoctorDetails" style="background:red; font-size: 16px; cursor:pointer">
    </form></td>
   </tr>
  </c:forEach>
 </table> 
</c:when>
<c:otherwise><h4>no appointments today</h4></c:otherwise>
</c:choose>
</div>
<div align="center">
<form action="viewAllAppointments">
 <input type="submit" value="All Appointments" style="background:red; font-size: 16px; cursor:pointer">
</form>
</div>
</body>
</html>