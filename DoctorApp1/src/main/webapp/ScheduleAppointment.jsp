<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Schedule Your Appointment </title>
        <script>
        function validDate(){
    	    var today = new Date().toISOString().split('T')[0];
    	    var nextWeekDate = new Date(new Date().getTime() + 6 * 24 * 60 * 60 * 1000).toISOString().split('T')[0]
          document.getElementsByName("date")[0].setAttribute('min', today);
          document.getElementsByName("date")[0].setAttribute('max', nextWeekDate)
    	}
        </script>
        <style>
body {
  background-image: url('static/images/hospital.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}
</style>
    </head>
</head>
<body onload="validDate()">
<div align="center">
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
    <form action="datetime">
       select date   <input type="date" name="date" id="date" class="form-control input-sm " required /><br>
       <select name="time">
       <option value="10:00">10.00</option>
       <option value="10:15">10.15</option>
       <option value="10:30">10.30</option>
       <option value="10:45">10.45</option>
       <option value="11:00">11.00</option>
       <option value="11:15">11.15</option>
       <option value="11:30">11.30</option>
       <option value="11:45">11.45</option>
       <option value="12:00">12.00</option>
       <option value="12:15">12.15</option>
       <option value="12:30">12.30</option>
       <option value="12:45">12.45</option>
       <option value="13:00">13.00</option>
       <option value="13:15">13.15</option>
       <option value="13:30">13.30</option>
       <option value="13:45">13.45</option>
       </select>
       <input type="hidden" value="${doctorId }" name="doctorId">
       <input type="submit" value="book" style="background:red; font-size: 16px; cursor:pointer">
    </form>
  </div>  
 </body>
</html>