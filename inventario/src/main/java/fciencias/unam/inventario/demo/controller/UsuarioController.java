package fciencias.unam.inventario.demo.controller;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fciencias.unam.inventario.demo.entity.Usuario;
import fciencias.unam.inventario.demo.repository.UsuarioRepository;
import fciencias.unam.inventario.demo.service.JEmailService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    JEmailService emailService=new JEmailService();
    
    @Autowired
    private UsuarioRepository repo;
     Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


    // READ
    @GetMapping("/")
    public String index(Model model) {
        List<Usuario> usuarios = repo.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario/index";
    }

    // CREATE
    @GetMapping("/formularioAgregarUsuario")
    public String agregarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/formularioAgregarUsuario";
    }

    

    @PostMapping("/formularioAgregarUsuario")
    public String procesandoAgregarUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult result) {

        if (result.hasErrors()) {
            result.getAllErrors();
            return "usuario/formularioAgregarUsuario";
        }

        repo.save(usuario);
        emailService.sendEmail(usuario.getCorreo(),"USUARIO AGREGADO",
         "FELICIDADES\n tu usuario ha sido agregado exitosamente en ensaladaCiencias");
        return "redirect:/usuario/";
    }

    // UPDATE
    @GetMapping("/formularioEditarUsuario/{id}")
    public String editarUsuario(@PathVariable long id, Model model) {

        // Obteniedo usuario
        Usuario usuario = repo.findById(id).orElse(null);

        model.addAttribute("usuario", usuario);
        model.addAttribute("id", id);

        return "usuario/formularioEditarUsuario";
    }

    @PostMapping("/formularioEditarUsuario/{id}")
    public String procesandoEditarUsuario(@PathVariable long id, @Valid @ModelAttribute Usuario usuario, BindingResult result) {
        Matcher mather = pattern.matcher(usuario.getCorreo());
       
        if (result.hasErrors()) {
            result.getAllErrors();
            return "usuario/formularioEditarUsuario";
        }else if(!mather.find()){
            return "usuario/formularioEditarUsuario";
        }

        // Actualizando los datos
        Usuario usuarioActual = repo.findById(id).orElse(null);
        usuarioActual.setCurp(usuario.getCurp());
        usuarioActual.setNombre(usuario.getNombre());
        usuarioActual.setAPaterno(usuario.getAPaterno());
        usuarioActual.setAMaterno(usuario.getAMaterno());
        usuarioActual.setSaldo(usuario.getSaldo());
        usuarioActual.setCorreo(usuario.getCorreo());

        repo.save(usuarioActual);
        return "redirect:/usuario/";
    }
  

    // DELETE
    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable long id) {
        repo.deleteById(id);
        return "redirect:/usuario/";
    }

}
