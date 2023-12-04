package fciencias.unam.inventario.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fciencias.unam.inventario.demo.entity.Mail;
import fciencias.unam.inventario.demo.service.JEmailService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/correo")

public class MailController {
    
    @Autowired
    private JEmailService emailService;
    
    @GetMapping("/enviarCorreo")
    public String enviarMensaje(Model model){

       model.addAttribute("correo", new Mail());
     
       return "correo/enviarCorreo";
    }
     
    @PostMapping("/enviarCorreo")
    public String procesandoEnviarMensaje(@Valid @ModelAttribute Mail correo,BindingResult result ) {
        
        if (result.hasErrors()) {
            result.getAllErrors();
           
            return "correo/enviarCorreo";
        }
        
        emailService.sendEmail2(correo.getToUser(),correo.getSubject(), correo.getMessage());
        return "redirect:/usuario/";
    }
    
}
