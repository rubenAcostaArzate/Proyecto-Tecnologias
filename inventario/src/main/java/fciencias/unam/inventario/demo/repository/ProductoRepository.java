package fciencias.unam.inventario.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fciencias.unam.inventario.demo.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
