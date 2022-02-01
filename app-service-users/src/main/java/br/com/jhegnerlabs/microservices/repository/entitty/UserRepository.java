package br.com.jhegnerlabs.microservices.repository.entitty;

import br.com.jhegnerlabs.microservices.repository.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
