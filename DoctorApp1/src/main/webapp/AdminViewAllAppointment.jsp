<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Appointment</title>  
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
   <div align="center">
   All the Appointments
<c:choose>
  <c:when test="${not empty appointments}">
  <table border="1" class="hoverTable" >
    <tr align="center" >
    <th>Appointment Id</th>
    <th>Doctor Id</th>
    <th>Customer ID</th>
    <th>Appointment Date</th>
    <th>Appointment Time</th>
  </tr>
  <c:forEach items="${appointments}" var="appointment" >
   <tr align="center" >
    <td>${appointment.aid}</td>
    <td>${appointment.doctorid}</td>
    <td>${appointment.patientid} </td>
    <td>${appointment.date}</td>
    <td>${appointment.time}</td>
   </tr>
  </c:forEach>
 </table> 
</c:when>
<c:otherwise><h4>no appointments today</h4></c:otherwise>
</c:choose>
   </div>
</body>
</html>