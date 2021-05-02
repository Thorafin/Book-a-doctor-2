package com.roshan;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roshan.Dao.DoctorDao;
import com.roshan.Dao.PatientDao;
import com.roshan.Entities.Patient;

@WebServlet("/patientRegister")
public class PatientRegisterController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name = request.getParameter("name");
	String password= request.getParameter("password");
	String number = request.getParameter("mobile");
	String email = request.getParameter("email");
	
	Patient p = new Patient();
	p.setName(name);
	p.setPassword(password);
	p.setNumber(number);
	p.setEmail(email);
	PatientDao dao = new PatientDao();
	try {
		if(dao.setPatient(p)) {
			response.sendRedirect("LoginPatient.jsp");
		}
		else {
			response.sendRedirect("RegisterPatient.jsp");
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
