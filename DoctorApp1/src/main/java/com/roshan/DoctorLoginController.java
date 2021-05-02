package com.roshan;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roshan.Dao.AppointmentDao;
import com.roshan.Dao.DoctorDao;
import com.roshan.Entities.Appointment;
import com.roshan.Entities.Doctor;


@WebServlet("/loginDoctor")
public class DoctorLoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String name=request.getParameter("username");
	  String pass = request.getParameter("password");
	    DoctorDao dao = new DoctorDao();
	try {
		if(dao.getDoctor(name, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("label",name);
			Doctor doctor = dao.getDoctorDetails(name, pass);
			AppointmentDao appDao = new AppointmentDao();
			List<Appointment> appointments = appDao.getAppointmentByDoctorIdPresent(doctor.getId());
			request.setAttribute("appointments", appointments);
			request.setAttribute("name", name);
			request.setAttribute("doctorid",doctor.getId());
			RequestDispatcher rd = request.getRequestDispatcher("DisplayDoctor.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("index.jsp");
		}
	} catch (IOException e) {
		e.printStackTrace();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	}
}
