package fciencias.unam.inventario.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fciencias.unam.inventario.demo.entity.Inventario;
import fciencias.unam.inventario.demo.entity.Producto;
import fciencias.unam.inventario.demo.repository.InventarioRepository;


@Service
public class InventarioService {
    

    @Autowired
    private InventarioRepository repository;


    public List<Producto> getProductos() {
        return repository.findAll();
    }

    public Inventario saveProducto(Inventario inventario) {
        //return repository.save(inventario);
        return null;
        
    }

}
