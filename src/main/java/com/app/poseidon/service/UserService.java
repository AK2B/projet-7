package com.app.poseidon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.poseidon.validator.CustomPasswordValidator;

@Service
public class UserService {
    private CustomPasswordValidator passwordValidator;

    @Autowired
    public UserService(CustomPasswordValidator passwordValidator) {
        this.passwordValidator = passwordValidator;
    }

    public boolean createUserWithValidatedPassword(String username, String password) {
        if (!passwordValidator.validatePassword(password)) {
            return false;
        }
        return true;
    }
    
    public boolean updateUserPassword(String userId, String newPassword) {
        if (!passwordValidator.validatePassword(newPassword)) {
            return false;
        }
        return true;
    }
    
    
}
