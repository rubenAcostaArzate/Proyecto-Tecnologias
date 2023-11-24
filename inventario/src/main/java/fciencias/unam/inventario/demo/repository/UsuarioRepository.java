package fciencias.unam.inventario.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fciencias.unam.inventario.demo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
