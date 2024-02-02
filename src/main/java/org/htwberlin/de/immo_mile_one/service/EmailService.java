package org.htwberlin.de.immo_mile_one.service;

import jakarta.annotation.PostConstruct;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(String reception, String titleMail, String body){
        MimeMessage message =emailSender.createMimeMessage();
        try {
            message.setFrom( new InternetAddress("noreply@immo-mile.com"));
            message.setContent(body, "text/html; charset=utf-8");
            message.setSubject(titleMail);
            message.setRecipients(MimeMessage.RecipientType.TO,reception);
            emailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }



}
