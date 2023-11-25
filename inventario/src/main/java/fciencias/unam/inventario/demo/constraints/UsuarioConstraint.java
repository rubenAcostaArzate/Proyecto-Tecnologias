package fciencias.unam.inventario.demo.constraints;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


    
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsuarioValidator.class)
public@interface UsuarioConstraint {
    String message() default "El correo debe ser valido";

        Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

