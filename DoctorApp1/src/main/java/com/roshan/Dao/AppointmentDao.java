package com.roshan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.roshan.Entities.Appointment;
import com.roshan.Entities.Doctor;

public class AppointmentDao {

	public boolean addAppointment(Appointment ap) throws SQLException, ClassNotFoundException {
		String query="insert into appointment(patientid,doctorid,appointment_date,appointment_time) values(?,?,?,?)";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1,ap.getPatientid());
		st.setInt(2,ap.getDoctorid());
		st.setString(3,ap.getDate());
		st.setString(4,ap.getTime());
		int count = st.executeUpdate();
		if(count>0) {
			con.close();
			return true;
		}
		else {
			con.close();
		return false;
	}
	}
	
	public Appointment getAppointment(int pid,int did) throws ClassNotFoundException, SQLException {
		Appointment ap = new Appointment();
		String query = "select * from appointment where doctorid=? and patientid=?";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, pid);
		st.setInt(2, did);
		ResultSet rs = st.executeQuery();
		while(rs.next()) 
		{
		ap.setAid(rs.getInt("aid"));	
		ap.setDate(rs.getString("appointment_date"));
		ap.setTime(rs.getString("appointment_time"));
		ap.setDoctorid(rs.getInt("doctorid"));
		ap.setPatientid(rs.getInt("patientid"));
		}
		return ap;	
	}
	
	public List<Appointment> getAppointmentById(int pid) throws ClassNotFoundException, SQLException {
		ArrayList<Appointment> ap = new ArrayList<Appointment>();
		String query = "select * from appointment where patientid=?";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, pid);
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
	 
	
	public List<Appointment> getAppointmentByDoctorId(int did) throws ClassNotFoundException, SQLException {
		ArrayList<Appointment> ap = new ArrayList<Appointment>();
		String query = "select * from appointment where doctorid=?";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, did);
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
	
	public List<Appointment> getAppointmentByDoctorIdPresent(int did) throws ClassNotFoundException, SQLException {
		ArrayList<Appointment> ap = new ArrayList<Appointment>();
		String query = "select * from appointment where appointment_date=current_date() and doctorid=?";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, did);
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
	
	public List<Appointment> getAppointmentByDoctorIdFuture(int did) throws ClassNotFoundException, SQLException {
		ArrayList<Appointment> ap = new ArrayList<Appointment>();
		String query = "select * from appointment where appointment_date>current_date() and doctorid=?";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, did);
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
	
	
	public  boolean  isAvailable(Appointment ap) throws Exception
	{
		String query= "select * from appointment where  doctorid=?  and appointment_date=? and appointment_time=?" ;
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1,ap.getDoctorid());
		st.setString(2,ap.getDate());
		st.setString(3,ap.getTime());
		 ResultSet rs = st.executeQuery();
		    if(rs.next()) {
		    	con.close();
		    	return true;
		    }
		    else {	
		    	con.close();
		    	return false; }
		    }
	
	public  boolean  isFree(String date,String time,int did) throws Exception
	{
		String query= "select * from appointment where  appointment_date=? and appointment_time=? and doctorid=?" ;
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,date);
		st.setString(2,time);
		st.setInt(3,did);
		 ResultSet rs = st.executeQuery();
		    if(rs.next()) {
		    	con.close();
		    	return true;
		    }
		    else {	
		    	con.close();
		    	return false; 
		    	}
		    }
	
	public boolean changeAppointment(int aid,String date,String time) throws ClassNotFoundException, SQLException {
		String query = "Update appointment set appointment_date=? , appointment_time=?  where aid=?";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,date );
		st.setString(2,time);
		st.setInt(3,aid);
		int count = st.executeUpdate();
		if(count>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean deleteAppointment(int aid) throws ClassNotFoundException, SQLException {
		String query = "Delete from appointment  where aid=?";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1,aid);
		int count = st.executeUpdate();
		if(count>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
