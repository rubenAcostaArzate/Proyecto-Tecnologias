package fciencias.unam.inventario.demo.entity;

import lombok.Data;
import java.util.List;

@Data
public class Inventario {
    
    /** Id del inventario */
    private long id;

    /** Lista de productos */
    private List<Producto> productos;

    public List<Producto> getProductos() {
        return productos;
    }

    public long getId() {
        return id;
    }


}