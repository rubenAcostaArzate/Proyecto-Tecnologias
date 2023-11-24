package fciencias.unam.inventario.demo.controller;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ProductoValidator.class)
public@interface ProductoConstraint {
    String message() default "La fecha de caducidad debe ser posterior a la de inicio";

        Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
