package com.roshan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChangeAppointment")
public class ChangeAppointmentController extends HttpServlet {
public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	int aid =Integer.parseInt(request.getParameter("aid"));
	int doctorid =Integer.parseInt(request.getParameter("did"));
	int patientid =Integer.parseInt(request.getParameter("pid"));
	
      request.setAttribute("aid", aid);
      request.setAttribute("doctorid", doctorid);
      request.setAttribute("patientid", patientid);
      RequestDispatcher rd = request.getRequestDispatcher("ChangeAppointment.jsp");
      rd.forward(request, response);
}
}
