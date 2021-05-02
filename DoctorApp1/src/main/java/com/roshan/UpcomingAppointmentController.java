package com.roshan;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roshan.Dao.AppointmentDao;
import com.roshan.Entities.Appointment;

@WebServlet("/upcomingAppointments")
public class UpcomingAppointmentController extends HttpServlet {
public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	int did =Integer.parseInt(request.getParameter("did"));
	AppointmentDao dao = new AppointmentDao();
	try {
		List<Appointment> appointments = dao.getAppointmentByDoctorIdFuture(did);
		request.setAttribute("appointments", appointments);
		RequestDispatcher rd = request.getRequestDispatcher("Upcomingappointment.jsp");
		rd.forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
}
}
