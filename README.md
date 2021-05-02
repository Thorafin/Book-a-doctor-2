# Book-a-doctor-2
Create a tables admin , appointment, doctor ,patient 
copy and paste following for creation of table 
create table doctor (id int not null auto_increment, name varchar(30) not null,phone varchar(10) not null,specialist varchar(30),clinic varchar(30),building varchar(30), road varchar(30),area varchar(30),pin int , password varchar (20) , primary key(id)); 
create table Patient(id int not null auto_increment,  name varchar(30) not null,phone varchar(10) not null, password varchar(20),email varchar(30), primary key (id));
create table Appointment (aid int not null auto_increment,patientid int not null,doctorid int not null,appointment_date date not null,appointment_time varchar(10) , FOREIGN KEY (patientid) REFERENCES Patient(id), FOREIGN KEY (doctorid) REFERENCES doctor(id),primary key (aid));
create table admin(name varchar(30),password varchar(30));
Inside DoctorDao class mentioned your url , username and password for mysql connection .
Inside service packages mention our email adddress
