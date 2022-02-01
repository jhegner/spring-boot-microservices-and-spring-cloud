package br.com.jhegnerlabs.microservices.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String userId;

}
