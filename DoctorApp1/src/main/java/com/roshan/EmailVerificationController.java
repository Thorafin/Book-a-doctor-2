package com.roshan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roshan.service.EmailVerification;

@WebServlet("/emailverification")
public class EmailVerificationController extends HttpServlet  {
public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("mail");
	System.out.println(email);
	 EmailVerification verifiy = new EmailVerification();
	 String otp = verifiy.getOtp();
	 verifiy.sendMail(otp, email);
      HttpSession session = request.getSession();
      session.setAttribute("otp", otp);
      session.setAttribute("email",email);
	 RequestDispatcher rd = request.getRequestDispatcher("CheckOtp.jsp");
	 rd.forward(request, response);
   	
}
}
