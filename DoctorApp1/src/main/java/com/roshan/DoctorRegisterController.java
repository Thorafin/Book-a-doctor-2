package com.roshan;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roshan.Dao.DoctorDao;
import com.roshan.Entities.Doctor;
import com.roshan.service.AdminNotify;

@WebServlet("/doctorRegister")
public class DoctorRegisterController extends HttpServlet {

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Doctor d = new Doctor();
	    d.setName(request.getParameter("name"));
	    d.setPassword(request.getParameter("password"));
	    d.setPhone(request.getParameter("mobile"));
		d.setSpecialist(request.getParameter("specialist"));
		d.setClinic(request.getParameter("clinic"));
		d.setBuilding(request.getParameter("building"));
		d.setRoad(request.getParameter("road"));
		d.setArea(request.getParameter("area"));
		d.setPin(Integer.parseInt(request.getParameter("pin")));
		 System.out.println(d);
	    DoctorDao dao = new DoctorDao();
	    try {
			if(dao.setDoctor(d)) {
			request.setAttribute("Doctor", d);
			AdminNotify admin = new AdminNotify();
			admin.sendMail(d.getName());
			RequestDispatcher rd = request.getRequestDispatcher("DoctorLogin.jsp");
			rd.forward(request, response);
}
			else {
				response.sendRedirect("DoctorRegister.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
