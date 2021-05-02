package com.roshan.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AdminNotify {
	public void sendMail(String name) {
    	System.out.println( "sending email ......" );
        String message ="Dear,Admin new Doctor Registered with name  "+name;
        String subject = "Book A Doctor : New Doctor Register";
        String from =null;
		String host ="smtp.gmail.com";
		String to =null;
		//get system properties
		Properties properties = System.getProperties();
		System.out.println(properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//step 1. to get session object
	    Session session = Session.getInstance(properties,new Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication("roshan20022000@gmail.com", "Roshan@9495");
			}
		} );
	    
	   
	    session.setDebug(true);
	    //step 1. compose message
	    MimeMessage m = new MimeMessage(session);
	    
	    try {
	      //sender
	    	m.setFrom(from);
	    	
	    //recipent
	          m.addRecipient( Message.RecipientType.TO, new InternetAddress(to));    
	          
	      //adding subject
	          m.setSubject(subject);
	          
	       //adding text
	          m.setText(message);
	          
	       //step 3. send the message using transport class
	          Transport.send(m);
	          System.out.println("sent Sucessss..........");
	          
	    }catch (Exception e) {
			e.printStackTrace();
		}
	    
    }

}
