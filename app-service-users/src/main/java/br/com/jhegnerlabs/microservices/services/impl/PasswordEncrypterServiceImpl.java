package br.com.jhegnerlabs.microservices.services.impl;

import br.com.jhegnerlabs.microservices.services.PasswordEncrypterService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Base64;

@Service
public class PasswordEncrypterServiceImpl implements PasswordEncrypterService {

    @Override
    public String encrypte(String password) {
        return Arrays.toString(Base64.getDecoder().decode(password));
    }
}
