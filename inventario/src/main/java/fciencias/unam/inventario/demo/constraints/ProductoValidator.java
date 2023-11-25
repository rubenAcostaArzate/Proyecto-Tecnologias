package fciencias.unam.inventario.demo.constraints;
import fciencias.unam.inventario.demo.entity.Producto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductoValidator implements ConstraintValidator<ProductoConstraint,Producto>{
    
    @Override
    public void initialize(ProductoConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Producto producto, ConstraintValidatorContext constraintValidatorContext) {

        return producto != null && producto.getFechaAdquision().isAfter(producto.getFechaCaducidad());
    }

}
