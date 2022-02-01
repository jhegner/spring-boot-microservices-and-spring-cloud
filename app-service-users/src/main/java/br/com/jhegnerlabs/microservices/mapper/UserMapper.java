package br.com.jhegnerlabs.microservices.mapper;

import br.com.jhegnerlabs.microservices.dto.UserDTO;
import br.com.jhegnerlabs.microservices.model.request.CreateUserRequest;
import br.com.jhegnerlabs.microservices.repository.UserEntity;

import static org.apache.commons.lang.StringUtils.EMPTY;

public class UserMapper implements Mapper<UserDTO, UserEntity> {

    @Override
    public UserEntity map(UserDTO source) {
        return new UserEntity(
                Long.parseLong(source.getUserId()),
                source.getFirstName(),
                source.getLastName(),
                source.getEmail(),
                source.getEncriptedPassword()
        );
    }

    public UserDTO map(UserEntity source) {
        return new UserDTO(
                source.getFirstName(),
                source.getLastName(),
                EMPTY,
                source.getEmail(),
                source.getId().toString(),
                EMPTY
        );
    }

    public UserDTO map(CreateUserRequest source) {
        return new UserDTO(
                source.getFirstName(),
                source.getLastName(),
                source.getPassword(),
                source.getEmail(),
                EMPTY,
                EMPTY
        );
    }
}