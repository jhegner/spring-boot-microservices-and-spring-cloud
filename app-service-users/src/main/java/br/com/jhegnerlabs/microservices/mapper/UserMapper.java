package br.com.jhegnerlabs.microservices.mapper;

import br.com.jhegnerlabs.microservices.dto.UserDTO;
import br.com.jhegnerlabs.microservices.model.request.CreateUserRequest;
import br.com.jhegnerlabs.microservices.model.response.CreateUserResponse;
import br.com.jhegnerlabs.microservices.repository.UserEntity;

import java.time.LocalDateTime;

import static org.apache.commons.lang.StringUtils.EMPTY;

public class UserMapper implements Mapper<UserDTO, UserEntity> {

    @Override
    public UserEntity map(UserDTO source) {
        return new UserEntity(
                null,
                source.getUserId(),
                source.getFirstName(),
                source.getLastName(),
                source.getEmail(),
                source.getEncriptedPassword(),
                LocalDateTime.now()
        );
    }

    public UserDTO map(UserEntity source) {
        return new UserDTO(
                source.getUserId(),
                source.getFirstName(),
                source.getLastName(),
                EMPTY,
                source.getEmail(),
                EMPTY
        );
    }

    public UserDTO map(CreateUserRequest source) {
        return new UserDTO(
                EMPTY,
                source.getFirstName(),
                source.getLastName(),
                source.getPassword(),
                source.getEmail(),
                EMPTY
        );
    }

    public CreateUserResponse mapToResponse(UserDTO source) {
        return new CreateUserResponse(
                source.getFirstName(),
                source.getLastName(),
                source.getEmail(),
                source.getUserId()
        );
    }
}
