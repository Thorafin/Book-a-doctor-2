<%@page import="com.roshan.Entities.Doctor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Page</title>

<style>
body {
  background-image: url('static/images/hospital.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}
</style>
</head>
<body >
<%
String label=(String)session.getAttribute("label");
if(label==null){
	response.sendRedirect("LoginPatient.jsp");
}

List<Doctor> doctors=(List<Doctor>)request.getAttribute("doctors"); 
session.setAttribute("doctors",doctors);
%>

  <div align="center">
    <table border="1" >
  <tr align="center" >
    <th>Doctor Name</th>
    <th>Phone number</th>
    <th>Specialist</th>
    <th>Clinic Name </th>
    <th>Building Name </th>
    <th>Road Name</th>
    <th>Area Name</th>
     <th>Pin Code</th>
    <th>Book</th>
  </tr>
  <c:forEach items="${doctors}" var="doctor" >
   <tr align="center" >
    <td>${doctor.name}</td>
    <td>${doctor.phone}</td>
    <td>${doctor.specialist}</td>
    <td>${doctor.clinic}</td>
    <td>${doctor.building}</td>
    <td>${doctor.road}</td>
    <td>${doctor.area}</td>
    <td>${doctor.pin}</td>
    <td><form action="book">
    <input type="hidden" name="doctorid" value="${doctor.id}" >
    <input type="submit" value="book" style="background:red; font-size: 16px; cursor:pointer"> </form> </td>
   </tr>
   
  </c:forEach>
</table> 

  </div>    
</body>
</html>