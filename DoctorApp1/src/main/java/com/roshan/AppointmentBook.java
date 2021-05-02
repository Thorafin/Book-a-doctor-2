package com.roshan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roshan.Dao.AppointmentDao;
import com.roshan.Dao.PatientDao;
import com.roshan.Entities.Appointment;
import com.roshan.Entities.Patient;

@WebServlet("/datetime")
public class AppointmentBook extends HttpServlet {
public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
	String date = request.getParameter("date");
	String time = request.getParameter("time");
	//System.out.println(date);
    int did = Integer.parseInt(request.getParameter("doctorId"));
	HttpSession session = request.getSession();
	String name = (String)session.getAttribute("label");
	String pass =(String) session.getAttribute("pass");
	PatientDao pd = new PatientDao();
		Patient patients = null;
		try {
			patients = pd.getPatientDetails(name, pass);
		} catch (Exception e) {
		System.out.println(e);
		}
		int id = patients.getId();
		Appointment ap = new Appointment();
		ap.setDate(date);
		ap.setDoctorid(did);
		ap.setPatientid(id);
	    ap.setTime(time);
		AppointmentDao dao = new AppointmentDao();
		 try {
			   if(dao.isAvailable(ap)) {
			  request.setAttribute("mesaage","The Doctor is not free !! Please select another date or time ");
			  RequestDispatcher rd = request.getRequestDispatcher("ScheduleAppointment.jsp");
				 rd.forward(request, response);
			 }
			 else
			 {
				 dao.addAppointment(ap);
				 List<Appointment> appointments = dao.getAppointmentById(id);
				 request.setAttribute("appointments",appointments );
				 RequestDispatcher rd = request.getRequestDispatcher("DisplayPatient.jsp");
				 rd.forward(request, response);
			 }
		} catch (Exception e) {
		System.out.println(e);
		}

	
}
}
