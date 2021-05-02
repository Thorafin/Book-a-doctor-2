package com.roshan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roshan.Entities.Doctor;


@WebServlet("/book")
public class AddAppointment extends HttpServlet {
public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	String id =request.getParameter("doctorid");
	HttpSession session = request.getSession();
	String name =(String) session.getAttribute("label");
	String pass =(String) session.getAttribute("pass");
	session.setAttribute("doctorid", id);
	 if(id!=null && name!=null && pass!=null )
	 {
		 request.setAttribute("doctorId",id);
		 RequestDispatcher rd = request.getRequestDispatcher("ScheduleAppointment.jsp");
		 rd.forward(request, response);
	 }
	 else
	  {
		 response.sendRedirect("BookingPage.jsp");
		 }
	 
}
}