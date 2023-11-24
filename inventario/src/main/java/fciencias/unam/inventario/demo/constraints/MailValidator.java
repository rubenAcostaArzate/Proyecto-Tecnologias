package fciencias.unam.inventario.demo.constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fciencias.unam.inventario.demo.entity.Mail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MailValidator implements ConstraintValidator<MailConstraint,Mail>{

    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    @Override
    public void initialize(MailConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Mail correo, ConstraintValidatorContext constraintValidatorContext) {
     Matcher mather = pattern.matcher(correo.getCorreo());

        return correo != null
               && mather.find();
        
    }

}
