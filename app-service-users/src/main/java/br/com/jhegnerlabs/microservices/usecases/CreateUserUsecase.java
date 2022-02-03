package br.com.jhegnerlabs.microservices.usecases;

import br.com.jhegnerlabs.microservices.dto.UserDTO;
import br.com.jhegnerlabs.microservices.mapper.UserMapper;
import br.com.jhegnerlabs.microservices.repository.UserEntity;
import br.com.jhegnerlabs.microservices.repository.entitty.UserRepository;
import br.com.jhegnerlabs.microservices.services.PasswordEncrypterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserUsecase {

    private final UserRepository repository;
    private final PasswordEncrypterService passEncrypterService;

    @Autowired
    public CreateUserUsecase(UserRepository repository, PasswordEncrypterService passEncrypterService) {
        this.repository = repository;
        this.passEncrypterService = passEncrypterService;
    }

    public UserDTO registra(UserDTO user) {

        user.setUserId(this.geraUserId());
        user.setEncriptedPassword(encriptyPassword(user.getPassword()));

        var userMapper = new UserMapper();

        return userMapper.map(repository.save(userMapper.map(user)));
    }

    public UserDTO consulta(String userId) {

        return new UserMapper().map(this.repository.findByUserId(userId));

    }

    private String encriptyPassword(String password) {
        return passEncrypterService.encrypte(password);
    }
    private String geraUserId() {
        return UUID.randomUUID().toString();
    }
}
