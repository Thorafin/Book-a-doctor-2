package com.roshan.Entities;

public class Appointment {
int aid;
int doctorid;
int patientid;
String date;
String time;

public Appointment() {

}
public Appointment(int aid, int doctorid, int patientid, String date, String time) {
	super();
	this.aid = aid;
	this.doctorid = doctorid;
	this.patientid = patientid;
	this.date = date;
	this.time = time;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}

public int getDoctorid() {
	return doctorid;
}
public void setDoctorid(int doctorid) {
	this.doctorid = doctorid;
}
public int getPatientid() {
	return patientid;
}
public void setPatientid(int patientid) {
	this.patientid = patientid;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
@Override
public String toString() {
	return "Appointment [aid=" + aid + ", doctorid=" + doctorid + ", patientid=" + patientid + ", date=" + date
			+ ", time=" + time + "]";
}



}
