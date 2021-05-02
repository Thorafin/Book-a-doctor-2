<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Otp Verification</title>
<style type="text/css">
body {
  background-image: url('static/images/hospital.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}
</style>
</head>
<body>
  Otp is send to your email ${email }
<form action="otpcheck">
 enter your otp <input type="text" name="userotp">
 <input type="submit" style="background:red; font-size: 16px; cursor:pointer">
</form>
if wrong email please  <a href="ForgotPasswordPatient.jsp">click here</a>
</body>
</html>