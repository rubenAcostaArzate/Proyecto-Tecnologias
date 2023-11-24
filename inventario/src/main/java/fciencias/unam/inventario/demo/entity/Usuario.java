package fciencias.unam.inventario.demo.entity;

import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;



@Data
@Entity
public class Usuario {

    /** Id del usuario */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;

    /** Nombre del usuario */
    @NotNull(message = "El nombre del usuario es obligatorio")
    @Column(name = "nombre")
    public String nombre;

    /** CURP del usuario */
    @NotNull(message = "El CURP del usuario es obligatorio")
    @Column(name = "curp")
    public String curp;

    /** Apellido paterno */
    @NotNull(message = "El apellido paterno del usuario es obligatorio")
    @Column(name = "a_paterno")
    public String aPaterno;

    /** Apellido materno */
    @NotNull(message = "El apellido materno del usuario es obligatorio")
    @Column(name = "a_materno")
    public String aMaterno;

    /** Saldo del usuario */
    @NotNull(message = "El saldo del usuario es obligatorio")
    @Column(name = "saldo")
    @Min(0)
    public double saldo;

    public String getNombre() {
        return nombre;
    }

    public String getCurp() {
        return curp;
    }

    public String getAMaterno() {
        return aMaterno;
    }

    public String getAPaterno() {
        return aPaterno;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public void setAMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public void setAPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }



}