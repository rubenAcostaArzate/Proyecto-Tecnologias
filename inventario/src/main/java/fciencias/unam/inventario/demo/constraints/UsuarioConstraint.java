package fciencias.unam.inventario.demo.constraints;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

public@interface UsuarioConstraint {
    

@Constraint(validatedBy = UsuarioValidator.class)
public@interface MailConstraint {
    String message() default "El correo debe ser valido";

        Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
}
