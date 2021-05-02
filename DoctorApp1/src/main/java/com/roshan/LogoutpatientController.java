package com.roshan;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutpatient")
public class LogoutpatientController extends HttpServlet{
public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
	HttpSession session = request.getSession();
	session.removeAttribute("label");
	session.invalidate();
	response.sendRedirect("LoginPatient.jsp");
}
}
