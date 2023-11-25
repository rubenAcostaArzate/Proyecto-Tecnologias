package fciencias.unam.inventario.demo.constraints;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fciencias.unam.inventario.demo.entity.Usuario;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsuarioValidator implements ConstraintValidator<UsuarioConstraint,Usuario>{

    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    @Override
    public void initialize(UsuarioConstraint constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Usuario usuario, ConstraintValidatorContext constraintValidatorContext) {
     Matcher mather = pattern.matcher(usuario.getCorreo());

        return usuario != null && mather.find();
        
    }
}
