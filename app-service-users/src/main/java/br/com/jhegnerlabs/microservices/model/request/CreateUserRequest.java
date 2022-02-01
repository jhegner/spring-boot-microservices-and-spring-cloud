package br.com.jhegnerlabs.microservices.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateUserRequest {

    @NotNull(message = "O primeiro nome nao pode ser nulo")
    @Size(min = 5, message = "O primeiro nome nao pode ser menor que cinco caracteres")
    private String firstName;

    @NotNull(message = "O ultimo nome nao pode ser nulo")
    @Size(min = 5, message = "O ultimo nome nao pode ser menor que cinco caracteres")
    private String lastName;

    @NotNull(message = "A senha nome nao pode ser nulo")
    @Size(min = 8, max = 16, message = "A senha deve ter no minimo 8 e no maximo 16 caracteres")
    private String password;

    @NotNull(message = "O email nome nao pode ser nulo")
    @Email(message = "Email informado eh invalido")
    private String email;


}
