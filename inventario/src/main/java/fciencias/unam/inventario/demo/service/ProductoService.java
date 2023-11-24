package fciencias.unam.inventario.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fciencias.unam.inventario.demo.entity.Producto;
import fciencias.unam.inventario.demo.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository repo;

    public List<Producto> getProductos() {
        return repo.findAll();
    }

    public Producto saveProducto(Producto producto) {
        return repo.save(producto);
    }

}
