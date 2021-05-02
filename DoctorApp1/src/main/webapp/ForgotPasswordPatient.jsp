<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password Page</title>
<style type="text/css">
body {
  background-image: url('static/images/hospital.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}
</style>
</head>
<body >
<div align="center">
 <p style="color: red;"> you have enter a wrong password </p>
     <form action="emailverification">
     enter your email here<input type="email" name="mail" required="required">
     <input type="submit" style="background:red; font-size: 16px; cursor:pointer">
     </form>
</div>
</body>
</html>