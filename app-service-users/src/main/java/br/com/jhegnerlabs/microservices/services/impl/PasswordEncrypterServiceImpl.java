package br.com.jhegnerlabs.microservices.services.impl;

import br.com.jhegnerlabs.microservices.services.PasswordEncrypterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncrypterServiceImpl implements PasswordEncrypterService {

    private final BCryptPasswordEncoder cryptPasswordEncoder;

    @Autowired
    public PasswordEncrypterServiceImpl(BCryptPasswordEncoder cryptPasswordEncoder) {
        this.cryptPasswordEncoder = cryptPasswordEncoder;
    }

    @Override
    public String encrypte(String password) {
        return cryptPasswordEncoder.encode(password);
    }
}
