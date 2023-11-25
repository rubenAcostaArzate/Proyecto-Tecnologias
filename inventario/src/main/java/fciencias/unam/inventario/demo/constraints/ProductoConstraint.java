package fciencias.unam.inventario.demo.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductoValidator.class)
public@interface ProductoConstraint {
    String message() default "La fecha de caducidad debe ser posterior a la de inicio";

        Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
