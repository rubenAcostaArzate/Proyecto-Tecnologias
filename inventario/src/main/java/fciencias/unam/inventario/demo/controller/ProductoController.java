package fciencias.unam.inventario.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Arrays;

import org.hibernate.persister.entity.OuterJoinLoadable;

import fciencias.unam.inventario.demo.entity.Producto;
import fciencias.unam.inventario.demo.repository.ProductoRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository repo;
    
    @ModelAttribute
    public void init(Model model) {
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
    }

    // CREATE
    @GetMapping("/formularioAgregarIngrediente")
    public String agregarIngrediente(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto/formularioAgregarIngrediente";
    }

    @PostMapping("/formularioAgregarIngrediente")
    public String procesandoAgregarIngrediente(@Valid @ModelAttribute Producto ingrediente, BindingResult result) {

        
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "producto/formularioAgregarIngrediente";
        }else if (ingrediente.getFechaAdquision().isAfter(ingrediente.getFechaCaducidad())) {
            System.out.println("La fecha adquisiscion no puede ser despues que fecha caducidad");
            return "producto/formularioAgregarIngrediente";
        }

        repo.save(ingrediente);
        return "redirect:/inventario/";
        
    }

    @GetMapping("/formularioEditarIngrediente")
    public String editarIngrediente() {
        return "producto/formularioEditarIngrediente";
    }

    // UPDATE
    @GetMapping("/formularioEditarIngrediente/{id}")
    public String editarIngrediente(@PathVariable long id, Model model) {

        // Obteniedo usuario
        Producto ingrediente = repo.findById(id).orElse(null);
       
        model.addAttribute("producto", ingrediente);
        model.addAttribute("id", id);

        return "producto/formularioEditarIngrediente";
    }

    @PostMapping("/formularioEditarIngrediente/{id}")
    public String procesandoEditarIngrediente(@PathVariable long id, @Valid @ModelAttribute Producto ingrediente, BindingResult result) {

       
        if (result.hasErrors()) {
            result.getAllErrors();
            return "producto/formularioEditarIngrediente";
        }else if (ingrediente.getFechaAdquision().isAfter(ingrediente.getFechaCaducidad())) {
            System.out.println("La fecha adquisiscion no puede ser despues que fecha caducidad");
            return "producto/formularioAgregarIngrediente";
        }

        // Actualizando los datos
        Producto ingredienteActual = repo.findById(id).orElse(null);
        ingredienteActual.setNombreProveedor(ingrediente.getNombreProveedor());
        ingredienteActual.setNombreProducto(ingrediente.getNombreProducto());
        ingredienteActual.setCosto(ingrediente.getCosto());
        ingredienteActual.setStock(ingrediente.getStock());
        ingredienteActual.setMedida(ingrediente.getMedida());
        ingredienteActual.setFechaAdquision(ingrediente.getFechaAdquision());
        ingredienteActual.setFechaCaducidad(ingrediente.getFechaCaducidad());
        ingredienteActual.setTipoProducto(ingrediente.getTipoProducto());
        ingredienteActual.setDescripcion(ingrediente.getDescripcion());
        ingredienteActual.setComentarios(ingrediente.getComentarios());

        repo.save(ingredienteActual);
        return "redirect:/inventario/";
    }
    
    

    @ModelAttribute("opcionesTipo")
    public List<String> getOpcionesTipo() {
        return Arrays.asList("solido", "liquido");
    }

    @ModelAttribute("opcionesMedida")
    public List<String> getOpcionesMedida() {
        return Arrays.asList("kg", "gr", "lb", "piezas");
    }

    // DELETE
    @GetMapping("/eliminarIngrediente/{id}")
    public String eliminarIngrediente(@PathVariable long id) {
        repo.deleteById(id);
        return "redirect:/inventario/";
    }   
}
