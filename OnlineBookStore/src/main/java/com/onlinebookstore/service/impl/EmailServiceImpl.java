/*
package com.onlinebookstore.service.impl;

import com.onlinebookstore.service.EmailService;
import org.hibernate.Session;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

public class EmailServiceImpl implements EmailService {
    @Override
    public boolean sendEmail(String subject, String message, String to) {
        boolean f= false;
        String from="prats091@gmail.com";
        String host="smtp.gmail.com";

        Properties properties=System.getProperties();
        System.out.println("Properties"+ properties);

        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.host",465);
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        Session session=Session.getInstance(properties, new Authenticator()){

            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("prats091@gmail.com","");

            }
        }


        return false;
    }
}
*/
