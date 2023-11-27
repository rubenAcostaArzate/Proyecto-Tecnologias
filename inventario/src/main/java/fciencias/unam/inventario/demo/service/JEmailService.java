package fciencias.unam.inventario.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import fciencias.unam.inventario.demo.controller.MailConfiguration;

public class JEmailService {
  
  @Autowired  
  private MailConfiguration mailconfig=new MailConfiguration();; 
  private JavaMailSender mailSender=mailconfig.getJavaMailSender();


    public void sendEmail(String toUser, String subject, String message){
     SimpleMailMessage mailMessage=new SimpleMailMessage();
     mailMessage.setFrom("botjavatest@outlook.com");
     mailMessage.setTo(toUser);
     mailMessage.setSubject(subject);
     mailMessage.setText(message);
    

     mailSender.send(mailMessage);
     
    }
}
