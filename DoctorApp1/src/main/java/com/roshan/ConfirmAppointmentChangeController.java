package com.roshan;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roshan.Dao.AppointmentDao;
import com.roshan.Entities.Appointment;

@WebServlet("/ConfirmChangeAppointment")
public class ConfirmAppointmentChangeController extends HttpServlet {
public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
	String date =request.getParameter("date") ;
	String time = request.getParameter("time");
	int aid =Integer.parseInt(request.getParameter("aid"));
	int did = Integer.parseInt(request.getParameter("did"));
	int pid = Integer.parseInt(request.getParameter("pid"));
	System.out.println(aid +":" +did+":"+pid);
	AppointmentDao dao = new AppointmentDao();
	try {
		if(dao.isFree(date, time, did) && dao.changeAppointment(aid, date, time)) {
			List<Appointment> appointments = dao.getAppointmentById(pid);
			request.setAttribute("appointments",appointments);
			RequestDispatcher rd = request.getRequestDispatcher("DisplayPatient.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("Error.jsp");
		}

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
