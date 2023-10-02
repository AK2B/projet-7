package com.app.poseidon.springboot;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.poseidon.config.CustomPasswordValidator;
import com.app.poseidon.service.UserService;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private CustomPasswordValidator passwordValidator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUserWithValidatedPassword_ValidPassword() {
        // Arrange
        String username = "testuser";
        String password = "ValidPassword123@";

        // Mock the password validator to return true for a valid password
        when(passwordValidator.validatePassword(password)).thenReturn(true);

        // Act
        boolean result = userService.createUserWithValidatedPassword(username, password);

        // Assert
        assertTrue(result);
        // Verify that validatePassword method was called with the correct password
        verify(passwordValidator, times(1)).validatePassword(password);
    }

    @Test
    public void testCreateUserWithValidatedPassword_InvalidPassword() {
        // Arrange
        String username = "testuser";
        String password = "invalid";

        // Mock the password validator to return false for an invalid password
        when(passwordValidator.validatePassword(password)).thenReturn(false);

        // Act
        boolean result = userService.createUserWithValidatedPassword(username, password);

        // Assert
        assertFalse(result);
        // Verify that validatePassword method was called with the correct password
        verify(passwordValidator, times(1)).validatePassword(password);
    }

    @Test
    public void testUpdateUserPassword_ValidPassword() {
        // Arrange
        String userId = "123";
        String newPassword = "NewValidPassword456@";

        // Mock the password validator to return true for a valid password
        when(passwordValidator.validatePassword(newPassword)).thenReturn(true);

        // Act
        boolean result = userService.updateUserPassword(userId, newPassword);

        // Assert
        assertTrue(result);
        // Verify that validatePassword method was called with the correct password
        verify(passwordValidator, times(1)).validatePassword(newPassword);
    }

    @Test
    public void testUpdateUserPassword_InvalidPassword() {
        // Arrange
        String userId = "123";
        String newPassword = "invalid";

        // Mock the password validator to return false for an invalid password
        when(passwordValidator.validatePassword(newPassword)).thenReturn(false);

        // Act
        boolean result = userService.updateUserPassword(userId, newPassword);

        // Assert
        assertFalse(result);
        // Verify that validatePassword method was called with the correct password
        verify(passwordValidator, times(1)).validatePassword(newPassword);
    }
}
