package com.roshan.service;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailVerification {
    public void sendMail(String otp,String email) {
    	System.out.println( "sending email ......" );
        String message ="hello ,Dear this is message for security check...."
        		+ "Your One Time Login Password is  "+otp;
        String subject = "Book A Doctor : Confirmation";
        String from =null;
		String host ="smtp.gmail.com";
		
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
	          m.addRecipient( Message.RecipientType.TO, new InternetAddress(email));    
	          
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
    
    //Generating random number
        
      public String getOtp() {
    	  Random random = new Random();
    	  int otp = random.nextInt(999999);
    	  return String.format("%06d",otp);
      }
       
    
    
    
    
}
