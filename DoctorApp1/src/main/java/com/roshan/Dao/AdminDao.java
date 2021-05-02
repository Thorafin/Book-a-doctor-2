package com.roshan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.roshan.Entities.Appointment;
import com.roshan.Entities.Doctor;
import com.roshan.Entities.Patient;

public class AdminDao {
	
	public boolean getAdmin(String name,String pass) throws ClassNotFoundException, SQLException {
		String query="select * from admin where name=? and password=?";
		Connection con = DoctorDao.getConnection();
	    PreparedStatement st = con.prepareStatement(query);
	    st.setString(1,name);
	    st.setString(2,pass);
	    ResultSet rs = st.executeQuery();
	    if(rs.next()) {
	    	con.close();
	    	return true;
	    }
	    else {
	    	con.close();
			return false;
	}}
	
	
	
	public List<Appointment> getAllAppointmenCurrent() throws ClassNotFoundException, SQLException {
		ArrayList<Appointment> ap = new ArrayList<Appointment>();
		String query = "select * from appointment where appointment_date=current_date() ";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		ResultSet rs = st.executeQuery();
		while(rs.next()) 
		{
			Appointment appoint = new Appointment(
					               rs.getInt("aid"),
					               rs.getInt("doctorid"),
					               rs.getInt("patientid"),
					               rs.getString("appointment_date"),
					               rs.getString("appointment_time")
		                                        );
			ap.add(appoint);
		}
		return ap;	
	}
	
	public List<Appointment> getAllAppointment() throws ClassNotFoundException, SQLException {
		ArrayList<Appointment> ap = new ArrayList<Appointment>();
		String query = "select * from appointment ";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		ResultSet rs = st.executeQuery();
		while(rs.next()) 
		{
			Appointment appoint = new Appointment(
					               rs.getInt("aid"),
					               rs.getInt("doctorid"),
					               rs.getInt("patientid"),
					               rs.getString("appointment_date"),
					               rs.getString("appointment_time")
		                                        );
			ap.add(appoint);
		}
		return ap;	
	}
	
	public List<Appointment> getAllAppointmentFuture() throws ClassNotFoundException, SQLException {
		ArrayList<Appointment> ap = new ArrayList<Appointment>();
		String query = "select * from appointment where appointment_date>current_date() ";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		ResultSet rs = st.executeQuery();
		while(rs.next()) 
		{
			Appointment appoint = new Appointment(
					               rs.getInt("aid"),
					               rs.getInt("doctorid"),
					               rs.getInt("patientid"),
					               rs.getString("appointment_date"),
					               rs.getString("appointment_time")
		                                        );
			ap.add(appoint);
		}
		return ap;	
	}
	
	public List<Patient> getPatientList() throws ClassNotFoundException, SQLException {
		ArrayList<Patient> patients = new ArrayList<Patient>();
		String query = "select * from patient ";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		ResultSet rs = st.executeQuery();
		while(rs.next()) 
		{
			Patient patient = new Patient();
			patient.setId(rs.getInt("id"));
			patient.setName(rs.getString("name"));
			patient.setEmail(rs.getString("email"));
			patient.setNumber(rs.getString("phone"));
			patients.add(patient);
		}
		return patients;	
	}
	
	public List<Doctor> getDoctorList() throws ClassNotFoundException, SQLException {
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		String query = "select * from doctor ";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		ResultSet rs = st.executeQuery();
		while(rs.next()) 
		{
			Doctor doctor = new Doctor();
			doctor.setId(rs.getInt("id"));
			doctor.setName(rs.getString("name"));
			doctor.setClinic(rs.getString("clinic"));
			doctor.setPhone(rs.getString("phone"));
			doctor.setBuilding(rs.getString("building"));
			doctor.setArea(rs.getString("area"));
			doctor.setRoad(rs.getString("road"));
			doctor.setSpecialist(rs.getString("specialist"));
			doctor.setPin(rs.getInt("pin"));
		   doctors.add(doctor);
		}
		return doctors;	
	}
	
	
	
}
