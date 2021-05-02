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

import com.roshan.Dao.DoctorDao;
import com.roshan.Dao.PatientDao;
import com.roshan.Entities.Doctor;

@WebServlet("/search")
public class SearchPatient extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String search= request.getParameter("search");
    DoctorDao dao = new DoctorDao();
    PatientDao pd = new PatientDao();
    try {
	      if(dao.getDoctorBySearch(search))
	         {
	    	      List <Doctor> doctors = pd.displayDoctor(search);
		          request.setAttribute("doctors",doctors); 
			       RequestDispatcher rd = request.getRequestDispatcher("BookingPage.jsp");
			       rd.forward(request, response);
		      }
		   else
		    {
			   RequestDispatcher rd = request.getRequestDispatcher("DisplayPatient.jsp");
			   request.setAttribute("message", "No Doctors available");
		       rd.forward(request, response);   
		    }
	} 
    catch (Exception e)
    {
		e.printStackTrace();
	}
	
   
	
	
	}
}
