package br.com.jhegnerlabs.microservices.controller;

import br.com.jhegnerlabs.microservices.mapper.UserMapper;
import br.com.jhegnerlabs.microservices.model.request.CreateUserRequest;
import br.com.jhegnerlabs.microservices.usecases.CreateUserUsecase;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;

import static java.util.logging.Level.INFO;

@RestController
@RequestMapping("/users")
@Log
public class UsersController {

    @Autowired
    private Environment env;

    @Autowired
    private CreateUserUsecase createUserUsecase;

    @GetMapping("/status/check")
    public String getStatus() {
        return "Executado na porta " + env.getProperty("local.server.port");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Validated @RequestBody CreateUserRequest model){

        log.log(INFO, "POST - Requisicao de novo usuario", model);

        createUserUsecase.create(new UserMapper().map(model));

    }

}
