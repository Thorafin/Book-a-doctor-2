<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"><meta charset="ISO-8859-1">
<meta charset="ISO-8859-1"><meta charset="ISO-8859-1"><meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<meta name="keywords" content="HOSPITAL,HOSPITAL.COM,HOSPITAL WEBSITE, MEDICAN">
	<meta name="description" content="india's best hospital website of indian">
	<meta name="author" content="hospital.com">
	  <style><%@include file="/static/css/index.css"%></style>
	<style><%@include file="/static/css/fontawesome/css/all.css"%></style>
	
<title>Doctor Display Page</title>
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
	response.sendRedirect("DoctorLogin.jsp");
}
%>
<div align="right">
    <form action="logoutdoctor">
    <input type="submit" value="logout" style="background:red; font-size: 16px; cursor:pointer">
    </form>
  </div>
            <div align="center">
             Welcome ${name}  <br>
      Todays appointments are
      <c:choose>    
     <c:when test="${not empty appointments }">      
     <table border="1"  class="hoverTable">
     <tr align="center" >
    <th>Appointment Id</th>
    <th>Customer ID</th>
    <th>Appointment Date</th>
    <th>Appointment Time</th>
  </tr>
  <c:forEach items="${appointments}" var="appointment" >
   <tr align="center" >
    <td>${appointment.aid}</td>
    <td>${appointment.patientid} </td>
    <td>${appointment.date}</td>
    <td>${appointment.time}</td>
   </tr>
  </c:forEach>
 </table> 
 </c:when>
 <c:otherwise><h5>no appointments today</h5></c:otherwise>
 </c:choose> 
</div> 
<div align="center">
<form action="allAppointments">
 <input type="hidden" name="did" value="${doctorid }">
 <input type="submit" value="All Appointments" style="background:red; font-size: 16px; cursor:pointer">
</form>
<form action="upcomingAppointments">
 <input type="hidden" name="did" value="${doctorid }">
 <input type="submit" value="Upcoming Appointments" style="background:red; font-size: 16px; cursor:pointer">
</form>
</div>

</body>
</html>