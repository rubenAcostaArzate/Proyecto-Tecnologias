package fciencias.unam.inventario.demo.controller;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import fciencias.unam.inventario.demo.entity.Producto;

public class ProductoValidator implements ConstraintValidator<ProductoConstraint,Producto>{
    
    @Override
    public void initialize(ProductoConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Producto producto, ConstraintValidatorContext constraintValidatorContext) {

        return producto != null
               && producto.getFechaAdquision().isAfter(producto.getFechaCaducidad());
    }

}
