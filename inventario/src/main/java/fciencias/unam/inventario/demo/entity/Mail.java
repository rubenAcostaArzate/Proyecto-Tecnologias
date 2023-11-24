package fciencias.unam.inventario.demo.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data;

@Embeddable
public class Mail {
    
    /*Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");*/

    String correo;  
                    
    
    
    public Mail(String correo){
        this.correo=correo;
    } 
    
    public Mail(){

    }
    /* 
    @NotNull
    public boolean esValido(){
        Matcher mather = pattern.matcher(correo);
        valido=mather.find();
        
        return valido;
    }*/

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
 
    
}
