package com.roshan.Entities;

public class Doctor {
int id;
String name;
String phone;
String Password;
String clinic; 
String building;
String road;
String area; 
int pin; 
String specialist;


public Doctor(int id, String name, String phone, String password, String clinic, String building, String road,
		String area, int pin, String specialist) {
	super();
	
	this.id = id;
	this.name = name;
	this.phone = phone;
	Password = password;
	this.clinic = clinic;
	this.building = building;
	this.road = road;
	this.area = area;
	this.pin = pin;
	this.specialist = specialist;
}
public Doctor() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getClinic() {
	return clinic;
}
public void setClinic(String clinic) {
	this.clinic = clinic;
}
public String getBuilding() {
	return building;
}
public void setBuilding(String building) {
	this.building = building;
}
public String getRoad() {
	return road;
}
public void setRoad(String road) {
	this.road = road;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public int getPin() {
	return pin;
}
public void setPin(int pin) {
	this.pin = pin;
}
public String getSpecialist() {
	return specialist;
}
public void setSpecialist(String specialist) {
	this.specialist = specialist;
}
@Override
public String toString() {
	return "Doctor [id=" + id + ", name=" + name + ", phone=" + phone + ", Password=" + Password + ", clinic=" + clinic
			+ ", building=" + building + ", road=" + road + ", area=" + area + ", pin=" + pin + ", specialist="
			+ specialist + "]";
}



}
