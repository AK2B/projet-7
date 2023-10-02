package com.app.poseidon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.poseidon.repositories.UserRepository;

/**
 * Service class for loading user details from the database for authentication.
 *
 * @Service
 */
@Service
public class PoseidonUserDetails implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    /**
     * Loads user details by username from the database.
     *
     * @param username of the user.
     * @return UserDetails representing the user.
     * @throws UsernameNotFoundException if the user is not found in the database.
    */ 
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = null;

        List<GrantedAuthority> authorities = null;
        com.app.poseidon.domain.User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        } else {
        	
            password = user.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
        }
        return new User(username, password, authorities);
    }
}