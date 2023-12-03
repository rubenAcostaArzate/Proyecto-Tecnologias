/**
 * 
 */
package fciencias.unam.inventario.demo.controller;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


/**
 * 
 */

@Configuration
public class MailConfiguration {
    
    @Bean
    public JavaMailSender getJavaMailSender(){
      JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
      
      /* Los correos se mandan por un protocolo llamado smtp
       * y agregamos el host para gmail, para otro tipo de correo seria necesario 
       * investigar el host para dicha direccion 
       */
      mailSender.setHost("smtp.freesmtpservers.com");
      //Cambiamos el puerto al puerto predeterminado de smtp
      mailSender.setPort(25);
      /* Direccion de correo con el que enviaremos los correos, por ahora es mi correo personal 
       * pero la idea es crear un correo ensaladas para cuando agregemos un usuario este correo
       * mande confirmacion y ademas para el apartado dudas o sugerencias pues el correo sera cambiado por el 
       * que ingrese el usuario
       */
      mailSender.setUsername("botjavatest@outlook.com");
      /* Agregamos la contraseña del correo, en la vida real esto es muy mala practica porque 
       * dejamos nuestra contraseña a plena vista y pues eso seria una falla de seguridad tremenda
       * pero para fines practicos de esta app academica lo dejamos asi*/
      mailSender.setPassword("jlaytbanjsayfcsnxytxvwu37658shag");
        
      Properties props=mailSender.getJavaMailProperties();

      //Agregamos propiedad que le dice que el protocolo que se usara sera el smtp
      props.put("mail.transport.protocol", "smtp");
       props.put("mail.protocol", "smtp");
      //Agregamos propiedad que sirve para autenticar el correo y la contraseña dadas
      props.put("mail.smtp.auth","false");
      //Agregamos propiedad que cifra la comunicacion de los mensajes de los correos
      //props.put("mail.smtp.starttls","true");
       //props.put("mail.smtp.starttls.enable","true");
        //props.put("mail.smtp.starttls.required","true");
      //Esta propiedad es simplemente para que se nos muestren los errores en consola
      props.put("mail.debug","true");

      return mailSender;
    }
}
