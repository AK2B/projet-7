package com.app.poseidon.springboot;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.app.poseidon.validator.PasswordValidator;

public class PasswordValidatorTests {

	 @Test
	    public void testValidPassword() {
	        assertTrue(PasswordValidator.isValid("Abc@1234"));
	        assertTrue(PasswordValidator.isValid("Xyz@5678"));
	    }

	    @Test
	    public void testInvalidPassword() {
	        assertFalse(PasswordValidator.isValid("invalid")); // Too short
	        assertFalse(PasswordValidator.isValid("noDigits@")); // No digits
	        assertFalse(PasswordValidator.isValid("NoSpecialChars12345")); // No special characters
	        assertFalse(PasswordValidator.isValid("Short@1")); // Too short
	        assertFalse(PasswordValidator.isValid("nonppercase@12345")); // No uppercase character
	    }
}
