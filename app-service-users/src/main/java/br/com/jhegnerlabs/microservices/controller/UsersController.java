package br.com.jhegnerlabs.microservices.controller;

import br.com.jhegnerlabs.microservices.mapper.UserMapper;
import br.com.jhegnerlabs.microservices.model.request.CreateUserRequest;
import br.com.jhegnerlabs.microservices.model.response.CreateUserResponse;
import br.com.jhegnerlabs.microservices.usecases.CreateUserUsecase;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity createUser(@RequestHeader Map<String, String> headers, @Validated @RequestBody CreateUserRequest model) {

        log.log(INFO, "POST - Requisicao de novo usuario", model);

        var userMapper = new UserMapper();

        var resultBody = userMapper.mapToResponse(createUserUsecase.create(userMapper.map(model)));

        return ResponseEntity.created(createResourceURI(resultBody, headers)).body(resultBody);

    }

    private URI createResourceURI(CreateUserResponse responseData, Map<String, String> headers) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(headers.get("x-forwarded-proto"))
                .host(Optional.of(headers.get("x-forwarded-host").split(":")[0]).filter(e -> !e.contains("localhost")).orElse("127.0.0.1"))
                .port(headers.get("x-forwarded-port"))
                .path("/users/{userdId}")
                .buildAndExpand(Map.of("userdId", responseData.getUserId()));

        return uriComponents.toUri();
    }

}
