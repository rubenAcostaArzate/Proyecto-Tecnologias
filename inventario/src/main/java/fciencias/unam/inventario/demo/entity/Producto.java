package fciencias.unam.inventario.demo.entity;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Producto {

    /** Id del tipo de producto */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private long idProducto;

    /** Nombre del producto */
    @NotNull(message = "El nombre del producto es obligatorio")
    @Column(name = "nombre_producto")
    public String nombreProducto;

    /** Stock del producto */
    @NotNull(message = "El stock del producto es obligatorio")
    public int stock;

    /** Medida del producto */
    @NotNull(message = "La medida del producto es obligatoria")
    public String medida;

    /** Tipo del producto */
    @NotNull(message = "El stock del producto es obligatorio")
    @Column(name = "tipo_producto")
    public String tipoProducto;

    /** Costo del producto */
    @NotNull(message = "El costo del producto es obligatorio")
    public float costo;

    /** Fecha de Adquision del producto */
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_adquision")
    public LocalDate fechaAdquision;

    /** Fecha de Caducidad del producto */
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_caducidad")
    public LocalDate fechaCaducidad;

    /** Nombre del proveedor */
    @NotNull(message = "El nombre del proveedor es obligatorio")
    @Column(name = "nombre_proveedor")
    public String nombreProveedor;

    /** Descripcion del producto */
    @NotNull(message = "La descripcion es obligatoria")
    public String descripcion;

    /** Comentarios del producto */
    public String comentarios;
    
}
