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

import com.roshan.Dao.PatientDao;
import com.roshan.Entities.Patient;

@WebServlet("/changePassword")
public class UpdatePatientPasswordController extends HttpServlet {
public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
String pass= request.getParameter("pass");
	HttpSession session = request.getSession();
	String name = (String)session.getAttribute("label");
	System.out.println(name +":" +pass);
	PatientDao dao  = new PatientDao();
	try {
		Patient patient = dao.getPatientDetails(name, pass);
		if(patient.getName().equals(name)) {
			HttpSession session1 = request.getSession();
			session1.setAttribute("patient",patient);
			response.sendRedirect("ConfirmPasswordChange.jsp");
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
