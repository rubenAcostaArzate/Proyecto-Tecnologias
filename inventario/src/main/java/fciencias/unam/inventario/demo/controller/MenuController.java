package fciencias.unam.inventario.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {
    
    @GetMapping("/")
    public String index() {

        return "menu/menu";
    }

    @GetMapping("/menu")
    public String menu() {

        return "menu/menu";
    }
}
