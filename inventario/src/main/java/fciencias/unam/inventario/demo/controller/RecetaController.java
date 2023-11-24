package fciencias.unam.inventario.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recetas")
public class RecetaController {
    
    @GetMapping("/")
    public String index() {

        return "recetas/index";
    }

    @GetMapping("/receta1")
    public String receta1() {

        return "recetas/receta1";
    }

    @GetMapping("/receta2")
    public String receta2() {
        return "recetas/receta2";
    }

    @GetMapping("/receta3")
    public String receta3() {
        return "recetas/receta3";
    }

    @GetMapping("/editarReceta")
    public String editarReeceta() {
        return "recetas/editarReceta";
    }
}
