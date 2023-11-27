package fciencias.unam.inventario.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class JEmailService {
  
  @Autowired  
  private JavaMailSender mailSender; 

    public void sendEmail(String toUser, String subject, String message){
     SimpleMailMessage mailMessage=new SimpleMailMessage();
     mailMessage.setFrom("rubenacostaarzate@ciencias.unam.mx");
     mailMessage.setTo(toUser);
     mailMessage.setSubject(subject);
     mailMessage.setText(message);

     mailSender.send(mailMessage);
     
    }
}
