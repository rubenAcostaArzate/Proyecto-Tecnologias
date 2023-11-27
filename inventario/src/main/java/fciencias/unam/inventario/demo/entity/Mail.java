package fciencias.unam.inventario.demo.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Embeddable
public class Mail {
    
    /*Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");*/

    String toUser;  

    String subject;

    String message;

    public String getToUser() {
        return toUser;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }
                    
    
    
    
 
    
}
