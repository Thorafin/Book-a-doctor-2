<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<meta name="keywords" content="HOSPITAL,HOSPITAL.COM,HOSPITAL WEBSITE, MEDICAN">
	<meta name="description" content="india's best hospital website of indian">
	<meta name="author" content="hospital.com">
	<title>Admin Page</title>
	<style><%@include file="/static/css/index.css"%></style>
	<style><%@include file="/static/css/fontawesome/css/all.css"%></style>
	 
	 
</head>
<body>
     <!-- Start Header Coding-->
<header>
	<div class="menu">
		<!-- Start Brand name coding-->
		<div class="brand-name">
				<h2>Book A doctor</h2>
			
		</div>
		<!-- End Brand name coding-->
		<!-- Start Nav coding & menu coding -->
         <nav>
         	<ul>
         		<li><a href="index.jsp">Home</a></li>
         		<li><a href="gallery.html">Gallery</a></li>
         		<li><a href="LoginPatient.jsp">Patient</a></li>
         		<li><a href="DoctorLogin.jsp">Doctor</a></li>                      
         	</ul>
         </nav>
		<!-- End Nav coding & menu coding -->
	</div>
</header>
<!-- End Header Coding-->
<!-- Start Section Coding-->
<section>
	<div class="w-80">
     <div class="form-box">
     	<h1>Admin Login Page</h1>
     	<hr>
     	<form action="adminlogin">
     		<label for="username"><b>Username :</b></label><br/>
				<input type="text" name="username" id="username" placeholder="username" required="required" />
				<br/><br/>

				<label for="password"><b>Password :</b></label>
				<br/>
				<input type="password" name="password" id="password"  required="required"/>
				<br/><br/>

				<button type="submit" id="login-btn">Login</button>
				
     	</form>
     </div>
    </div>
</section>
<!-- End Section Coding-->
<!-- Start Footer Coding-->
<footer>
	<div class="w-80">
		<div class="footer-box">
 		<h2>Services</h2>
 		<a href="#">HEPATOLOGY</a>
 		<a href="#">MEDICAL DRESSAGE</a>
 		<a href="#">LABORATORY</a>
 		<a href="#">VACCINATIONS</a>
 		<a href="#">WHITENING</a>
 	</div>
 	<div class="footer-box">
 		<h2>About Us</h2>
 		<a href="#">Company Overview</a>
 		<a href="#">Management</a>
 		<a href="#">Initiatives</a>
 		<a href="#">Carrers</a>
 		<a href="#">Our Doctors Achieve</a>
 	</div>
 	<div class="footer-box">
 		<h2>Contact Us</h2>
 		<a href="#">Post a Query</a>
 		<a href="#">Apollo Clinics</a>
 		<a href="#">Reach Hospitals</a>
 		<a href="#">Apollo Cradle</a>
 		<a href="#">Ask Question</a>
 	</div>
 	<div class="footer-box">
 		<h2>Facilities</h2>
 		<a href="#">HEPATOLOGY</a>
 		<a href="#">MEDICAL DRESSAGE</a>
 		<a href="#">LABORATORY</a>
 		<a href="#">VACCINATIONS</a>
 		<a href="#">WHITENING</a>
 	</div>
	</div>
</footer>
<!-- End footer Coding-->
  
</body>
</html>