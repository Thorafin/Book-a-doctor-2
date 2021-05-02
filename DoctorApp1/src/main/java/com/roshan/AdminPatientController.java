package com.roshan;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roshan.Dao.AdminDao;
import com.roshan.Entities.Patient;

@WebServlet("/patientList")
public class AdminPatientController extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse response) {
		AdminDao dao = new AdminDao();
		try {
			List<Patient> patients = dao.getPatientList();
			 request.setAttribute("patients", patients); 
			    RequestDispatcher rd = request.getRequestDispatcher("Adminpatientdisplay.jsp");
			    rd.forward(request, response);
		} catch (Exception e) {
		 e.printStackTrace();
		}
	}

}
