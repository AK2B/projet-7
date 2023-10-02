package com.app.poseidon.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.poseidon.repositories.UserRepository;
import com.app.poseidon.service.PoseidonUserDetails;

@SpringBootTest
public class PoseidonUserDetailsTest {

    @InjectMocks
    private PoseidonUserDetails userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);;
    }

    @Test
    public void testLoadUserByUsername_UserFound() {
        // Arrange
        String username = "testuser";
        com.app.poseidon.domain.User mockUser = new com.app.poseidon.domain.User();
        mockUser.setUsername(username);
        mockUser.setPassword("testpassword");
        mockUser.setRole("ROLE_USER");

        when(userRepository.findByUsername(username)).thenReturn(mockUser);

        // Act
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // Assert
        assertNotNull(userDetails);
        assertEquals(username, userDetails.getUsername());
        assertEquals("testpassword", userDetails.getPassword());
        assertEquals(1, userDetails.getAuthorities().size());
        assertEquals("ROLE_USER", userDetails.getAuthorities().iterator().next().getAuthority());

        verify(userRepository, times(1)).findByUsername(username);
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        // Arrange
        String username = "nonexistentuser";

        when(userRepository.findByUsername(username)).thenReturn(null);

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername(username);
        });

        verify(userRepository, times(1)).findByUsername(username);
    }
}
