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


@WebServlet("/DeleteAppointment")
public class DeleteAppointmentController extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int aid =Integer.parseInt(request.getParameter("aid"));
		int pid =Integer.parseInt(request.getParameter("pid"));
		AppointmentDao dao = new AppointmentDao();
		try {
			if(dao.deleteAppointment(aid)) {
				List<Appointment> appointments = dao.getAppointmentById(pid);
				request.setAttribute("appointments", appointments);
			    RequestDispatcher rd = request.getRequestDispatcher("DisplayPatient.jsp");
			    rd.forward(request, response);
			}
			else {
				response.sendRedirect("Error.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	}
