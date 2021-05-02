package com.roshan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roshan.Dao.PatientDao;
import com.roshan.Entities.Patient;

@WebServlet("/confirmPassword")
public class ConfirmPasswordChangeController extends HttpServlet {
public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String pass=request.getParameter("pass");
	String pass1 = request.getParameter("pass1");
	if(pass.equals(pass1)) {
   HttpSession session = request.getSession();
   String email  = (String)session.getAttribute("email");
	PatientDao dao = new PatientDao();
	try {
		Patient patient = dao.getPatientDetails(email);
		dao.changePassword(pass, patient.getId());
		session.removeAttribute("label");
		session.invalidate();
		response.sendRedirect("LoginPatient.jsp");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	else {
		response.sendRedirect("ConfirmPasswordChange.jsp");
	}
}
}
