package com.roshan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.roshan.Entities.Doctor;
import com.roshan.Entities.Patient;

public class PatientDao {
	
	public boolean getPatient(String name,String pass) throws ClassNotFoundException, SQLException {
		String query="select * from patient where name=? and password=?";
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
	
	public boolean setPatient(Patient p ) throws ClassNotFoundException, SQLException {
		String query="insert into patient(name,phone,password,email) values(?,?,?,?)";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,p.getName());
		st.setString(2,p.getNumber());
		st.setString(3,p.getPassword());
		st.setString(4,p.getEmail());
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
	public List <Doctor> displayDoctor(String search) throws ClassNotFoundException, SQLException {
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		String query = "select * from doctor where specialist=?";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,search);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
		Doctor doctor = new Doctor(rs.getInt("id"),
			                      rs.getString("name"),
			                      rs.getString("phone"),
			                      rs.getString("password"),
			                      rs.getString("clinic"),
			                      rs.getString("building"),
			                      rs.getString("road"),
			                      rs.getString("area"),
			                      rs.getInt("pin"),
			                      rs.getString("specialist"));
	       doctors.add(doctor);
		}
		return doctors;	
	}
	public boolean changePassword(String pass,int id) throws ClassNotFoundException, SQLException {
		String query = "Update patient set password=? where id=?";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, pass);
		st.setInt(2,id);
		int count = st.executeUpdate();
		if(count>0) {
			return true;
		}
		else {
			return false;
		}
	}
	public Patient getPatientDetails(String name,String pass) throws ClassNotFoundException, SQLException {
		String query="select * from patient where name=? and password=?";
		Connection con = DoctorDao.getConnection();
	    PreparedStatement st = con.prepareStatement(query);
	    st.setString(1,name);
	    st.setString(2,pass);
	    ResultSet rs = st.executeQuery();
	    Patient p = new Patient();
	    while(rs.next()) {
	    	p.setId(rs.getInt("id"));
	    	p.setName(rs.getString("name"));
	    	p.setNumber(rs.getString("phone"));
	        p.setPassword(rs.getString("password"));
	        p.setEmail(rs.getString("email"));
	    }
		return p;    
	}
	
	public Patient getPatientDetails(String email) throws ClassNotFoundException, SQLException {
		String query="select * from patient where email=?";
		Connection con = DoctorDao.getConnection();
	    PreparedStatement st = con.prepareStatement(query);
	    st.setString(1,email);
	    ResultSet rs = st.executeQuery();
	    Patient p = new Patient();
	    while(rs.next()) {
	    	p.setId(rs.getInt("id"));
	    	p.setName(rs.getString("name"));
	    	p.setNumber(rs.getString("phone"));
	        p.setPassword(rs.getString("password"));
	        p.setEmail(rs.getString("email"));
	    }
		return p;    
	}

}
