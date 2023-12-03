package fciencias.unam.inventario.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import fciencias.unam.inventario.demo.controller.MailConfiguration;

@Service
public class JEmailService {
  
  @Autowired  
  private MailConfiguration mailconfig=new MailConfiguration(); 
  @Autowired
  private JavaMailSender mailSender=mailconfig.getJavaMailSender();

    //Metodo que nos permite mandar un correo a un usuario con asunto y mensaje
    public void sendEmail(String toUser, String subject, String message){
     SimpleMailMessage mailMessage=new SimpleMailMessage();
     mailMessage.setFrom("botjavatest@outlook.com");
     mailMessage.setTo(toUser);
     mailMessage.setSubject(subject);
     mailMessage.setText(message);
    

     mailSender.send(mailMessage);
     
    }
    //Mensaje que nos permite que un usuario mande un correo con asunto y mensaje
    //al correo que creamos para probar la aplicacion 
    public void sendEmail2(String User, String subject, String message){
     SimpleMailMessage mailMessage=new SimpleMailMessage();
     mailMessage.setFrom(User);
     mailMessage.setTo("botjavatest@outlook.com");
     mailMessage.setSubject(subject);
     mailMessage.setText(message);
    

     mailSender.send(mailMessage);
     
    }

}
