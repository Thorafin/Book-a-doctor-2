package com.roshan;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/otpcheck")
public class OtpCheckController extends HttpServlet  {
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		 int userOtp =Integer.parseInt(request.getParameter("userotp"));
		 HttpSession session = request.getSession();
	      String otp = (String)session.getAttribute("otp");
	      int otpresult = Integer.parseInt(otp);
	      if(otpresult==userOtp) {
	    	  response.sendRedirect("ConfirmPasswordChange.jsp");
	      }
	      else {
	    	  response.sendRedirect("ForgotPasswordPatient.jsp");
	      }
}
}
