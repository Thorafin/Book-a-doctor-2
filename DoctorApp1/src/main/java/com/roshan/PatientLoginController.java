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
import com.roshan.Dao.PatientDao;
import com.roshan.Entities.Appointment;
import com.roshan.Entities.Patient;

@WebServlet("/loginPatient")
public class PatientLoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String name = request.getParameter("username");
   String password = request.getParameter("password");
   System.out.println(name +":"+password);
   PatientDao dao = new PatientDao();
   try {
	if(dao.getPatient(name,password)) {
		HttpSession session = request.getSession();
		session.setAttribute("label",name);
		session.setAttribute("pass",password);
		Patient patient = dao.getPatientDetails(name, password);
		AppointmentDao appDao = new AppointmentDao();
		List<Appointment> appointments = appDao.getAppointmentById(patient.getId());
		request.setAttribute("appointments", appointments);
	    RequestDispatcher rd = request.getRequestDispatcher("DisplayPatient.jsp");
	    rd.forward(request, response);
		}
	   else {
		   response.sendRedirect("ForgotPasswordPatient.jsp");
	   }
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
}
