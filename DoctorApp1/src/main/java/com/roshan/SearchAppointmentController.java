package com.roshan;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roshan.Dao.DoctorDao;
import com.roshan.Entities.Doctor;

@WebServlet("/searchAppointment")
public class SearchAppointmentController extends HttpServlet{
public void service(HttpServletRequest request,HttpServletResponse response) {
	int doctorId = Integer.parseInt( request.getParameter("doctorId"));
	DoctorDao dao = new DoctorDao();
	try {
		Doctor doctor = dao.getDoctorById(doctorId);
		request.setAttribute("doctor",doctor);
		RequestDispatcher rd = request.getRequestDispatcher("DoctorDetails.jsp");
		rd.forward(request, response);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
