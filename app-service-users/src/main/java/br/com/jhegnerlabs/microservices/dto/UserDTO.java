package br.com.jhegnerlabs.microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    private String userId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String encriptedPassword;

}
