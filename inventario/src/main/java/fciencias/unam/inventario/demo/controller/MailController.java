package fciencias.unam.inventario.demo.controller;

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

    private JEmailService emailService;
    
    @GetMapping("/")
    public String index() {

        return "correo/enviarCorreo";
    }

    @GetMapping("/enviarCorreo")
    public String agregaMail(Model model){
       model.addAttribute("correo", new Mail());
       return "correo/enviarCorreo";
    }

    @PostMapping("/enviarCorreo")
    public String enviarMensaje(@Valid @ModelAttribute Mail correo, BindingResult result){
        if (result.hasErrors()) {
            result.getAllErrors();
            return "correo/enviarCorreo";
        }

        emailService.sendEmail(correo.getToUser(), correo.getSubject(), correo.getMessage());
        return "redirect:/usuario/";
    }
}
