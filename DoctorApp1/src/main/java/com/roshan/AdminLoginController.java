package com.roshan;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roshan.Dao.AdminDao;
import com.roshan.Entities.Appointment;

@WebServlet("/adminlogin")
public class AdminLoginController extends HttpServlet {
public void service(HttpServletRequest request,HttpServletResponse response) {
	String name = request.getParameter("username");
	String password = request.getParameter("password");
	AdminDao dao = new AdminDao();
	try {
		if(dao.getAdmin(name, password)) {
			List<Appointment> appointments = dao.getAllAppointmenCurrent();
			HttpSession session = request.getSession();
			session.setAttribute("label",name);
			session.setAttribute("appointments", appointments);
			response.sendRedirect("AdminDisplay.jsp");
		}
		else {
			response.sendRedirect("AdminPage.jsp");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
