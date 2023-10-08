package com.app.poseidon.springboot;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.app.poseidon.validator.CustomPasswordValidator;

public class CustomPasswordValidatorTest {

	@Test
    public void testValidatePassword() {
        CustomPasswordValidator customValidator = new CustomPasswordValidator();
        assertTrue(customValidator.validatePassword("Abc@1234"));
        assertTrue(customValidator.validatePassword("Xyz@5678"));
        assertFalse(customValidator.validatePassword("invalid")); 
        assertFalse(customValidator.validatePassword("noDigits@")); 
        assertFalse(customValidator.validatePassword("NoSpecialChars12345")); 
        assertFalse(customValidator.validatePassword("Short@1")); 
        assertFalse(customValidator.validatePassword("nouppercase@12345")); 
    }
}
