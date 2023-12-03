package fciencias.unam.inventario.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Data

public class Mail {
  
    @Id
    int id;

    
    @Email
    @NotNull
    public String toUser;  
    @NotNull
    public String subject;
    @NotNull
    public String message;
    
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
