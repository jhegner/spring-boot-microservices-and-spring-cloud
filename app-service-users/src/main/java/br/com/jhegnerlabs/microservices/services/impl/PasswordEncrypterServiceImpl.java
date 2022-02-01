package br.com.jhegnerlabs.microservices.services.impl;

import br.com.jhegnerlabs.microservices.services.PasswordEncrypterService;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncrypterServiceImpl implements PasswordEncrypterService {

    @Override
    public String encrypte(String password) {
        // TODO implementar
        return password;
    }
}
