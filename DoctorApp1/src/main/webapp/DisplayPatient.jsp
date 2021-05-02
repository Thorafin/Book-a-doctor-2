<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
	
<title>Display patient Page</title>
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
	response.sendRedirect("LoginPatient.jsp");
}
%>
<c:if test="${not empty message }">
   <div align="center">
    <p style="color: red">${message }</p>
    
   </div>
</c:if>


 <div align="center">
   welcome patient <br>
   <form action="search" >
   <input type="text" name="search" placeholder="Doctor_Name,Specialist,Area_Name" required="required"><br> 
   <input type="submit" style="background:red; font-size: 16px; cursor:pointer" >
   </form>
   </div>
    <div align="center">
    <c:choose>
    <c:when test="${ not empty appointments }">
    <table border="1" class="hoverTable" >
  <tr align="center" >
    <th>Appointment Id</th>
    <th>Appointment Date</th>
    <th>Doctor Id</th>
    <th>Appointment Time</th>
    <th>Edit Appointment</th>
    <th>Search Doctor Details</th>
    <th>Delete Appointment</th>
    
  </tr>
  <c:forEach items="${appointments}" var="appointment" >
   <tr align="center" >
    <td>${appointment.aid}</td>
    <td>${appointment.date}</td>
    <th>${appointment.doctorid }</th>
    <td>${appointment.time}</td>
    <td>
    <form action="ChangeAppointment">
    <input type="hidden" name="aid" value="${appointment.aid}">
    <input type="hidden" name="did" value="${appointment.doctorid}">
    <input type="hidden" name="pid" value="${appointment.patientid}">
    
       <input type="submit" style="background:red; font-size: 16px; cursor:pointer" value="Edit">
    </form>
    </td>
    <td>
    <form action="searchAppointment">
    <input type="hidden" name="doctorId" value="${appointment.doctorid}">
    <input type="submit" value="DoctorDetails" style="background:red; font-size: 16px; cursor:pointer">
    </form></td>
    <td>
    <form action="DeleteAppointment">
    <input type="hidden" name="aid" value="${appointment.aid}">
    <input type="hidden" name="pid" value="${appointment.patientid}">
    <input type="submit" value="Delete" style="background:red; font-size: 16px; cursor:pointer">
    </form>
    </td>
   </tr>
  </c:forEach>
 </table> 
 </c:when>
 <c:otherwise>Book Appointments</c:otherwise>
 </c:choose>
</div> 
  <div align="center">
    <form action="logoutpatient">
    <input type="submit" value="logout" style="background:red; font-size: 16px; cursor:pointer">
    </form>
    </div>
  
</body>
</html>