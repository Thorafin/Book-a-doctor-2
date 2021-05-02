package com.roshan.Dao;


import com.roshan.Entities.Doctor;
import com.roshan.Entities.Patient;

import java.sql.*;

public class DoctorDao 
{
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 String name = null;
		 String password = null;
		 String url="jdbc:mysql://localhost:3306/";
		 
		Connection con= DriverManager.getConnection(name,password,url);
		return con;
	}
	

	public  boolean  setDoctor(Doctor d) throws Exception
	{
		String query="insert into doctor (name,phone,specialist,clinic,building,road,area,pin,password) values(?,?,?,?,?,?,?,?,?)";
		Connection con = DoctorDao.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,d.getName());
		st.setString(2,d.getPhone());
		st.setString(3,d.getSpecialist());
		st.setString(4,d.getClinic());
		st.setString(5,d.getBuilding());
		st.setString(6,d.getRoad());
		st.setString(7,d.getArea());
		st.setInt(8,d.getPin());
		st.setString(9,d.getPassword());
		 
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
	
	public boolean getDoctor(String uname,String pass) throws Exception
	{
		String query="select * from doctor where name=? and password=?";
		Connection con = DoctorDao.getConnection();
	    PreparedStatement st = con.prepareStatement(query);
	    st.setString(1,uname);
	    st.setString(2,pass);
	    ResultSet rs = st.executeQuery();
	    if(rs.next()) {
	    	con.close();
	    	return true;
	    }
	    else {	
	    	con.close();
	    	return false; }
	    }
	
	public Doctor getDoctorDetails(String uname,String pass) throws Exception
	{
		String query="select * from doctor where name=? and password=?";
		Connection con = DoctorDao.getConnection();
	    PreparedStatement st = con.prepareStatement(query);
	    st.setString(1,uname);
	    st.setString(2,pass);
	    ResultSet rs = st.executeQuery();
	    Doctor d = new Doctor();
	    while(rs.next()) {
	    	d.setId(rs.getInt("id"));
	    	d.setName(rs.getString("name"));
	        d.setClinic(rs.getString("clinic"));
	        d.setPhone(rs.getString("phone"));
	        d.setBuilding(rs.getString("building"));
	        d.setRoad( rs.getString("road"));
	        d.setArea(rs.getString("area"));
	        d.setPin( rs.getInt("pin"));
	        d.setSpecialist(rs.getString("specialist"));
	    }
	    return d;
	    }
	
	
	public boolean getDoctorBySearch(String search) throws Exception 
	{
		String query="select * from doctor where specialist=? ";
		Connection con = DoctorDao.getConnection();
	    PreparedStatement st = con.prepareStatement(query);
	    st.setString(1,search);
	    ResultSet rs = st.executeQuery();
	    if(rs.next()) {
	    	con.close();
	    	return true;
	    }
	    else {	
	    	con.close();
	    	return false; }
	    }
	
	
public Doctor getDoctorById(int id) throws Exception 
{
	String query="select * from doctor where id=? ";
	Connection con = DoctorDao.getConnection();
    PreparedStatement st = con.prepareStatement(query);
    st.setInt(1,id);
    ResultSet rs = st.executeQuery();
    Doctor d = new Doctor();
    while(rs.next()) {
    d.setName(rs.getString("name"));
    d.setClinic(rs.getString("clinic"));
    d.setPhone(rs.getString("phone"));
    d.setBuilding(rs.getString("building"));
    d.setRoad( rs.getString("road"));
    d.setArea(rs.getString("area"));
    d.setPin( rs.getInt("pin"));
    d.setSpecialist(rs.getString("specialist"));
        }
 return d;   
}
}
    
    

   
