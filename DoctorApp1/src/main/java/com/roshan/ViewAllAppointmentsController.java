package com.roshan;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roshan.Dao.AdminDao;
import com.roshan.Entities.Appointment;

@WebServlet("/viewAllAppointments")
public class ViewAllAppointmentsController extends HttpServlet {
public void service(HttpServletRequest request,HttpServletResponse response) {
	AdminDao dao = new AdminDao();
	try {
		List<Appointment> appointments = dao.getAllAppointment();
		request.setAttribute("appointments", appointments);
		RequestDispatcher rd = request.getRequestDispatcher("AdminViewAllAppointment.jsp");
		rd.forward(request, response);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
