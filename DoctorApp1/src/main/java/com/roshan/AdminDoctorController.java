package com.roshan;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roshan.Dao.AdminDao;
import com.roshan.Entities.Doctor;

@WebServlet("/doctorList")
public class AdminDoctorController extends HttpServlet{
 public void service(HttpServletRequest request,HttpServletResponse response) {
    	AdminDao dao = new AdminDao();
        try {
			List<Doctor> doctors = dao.getDoctorList();
		    request.setAttribute("doctors", doctors); 
		    RequestDispatcher rd = request.getRequestDispatcher("Admindoctordisplay.jsp");
		    rd.forward(request, response);
            } 
        catch (Exception e) {
		 e.printStackTrace();
		}
    
    }
}
