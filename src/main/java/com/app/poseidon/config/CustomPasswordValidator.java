package com.app.poseidon.config;

import org.springframework.stereotype.Component;

@Component
public class CustomPasswordValidator {
    public boolean validatePassword(String password) {
        return PasswordValidator.isValid(password);
    }
}

