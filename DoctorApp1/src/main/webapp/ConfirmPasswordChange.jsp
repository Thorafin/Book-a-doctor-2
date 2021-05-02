<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Change Page</title>
<style>
body {
  background-image: url('static/images/hospital.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}
</style>
</head>
<body>

       <div align="center">
       <form action="confirmPassword">
           enter your new password<input type="text" name="pass"><br>
          please renter the same password<input type="text" name="pass1"><br>
          
       <input type="submit">
       </form>
       </div>
</body>
</html>