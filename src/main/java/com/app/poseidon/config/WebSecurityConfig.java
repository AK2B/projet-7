package com.app.poseidon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for setting up web security in the application.
 *
 * @Configuration
 * @EnableWebSecurity
*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
 
	/**
	 * Defines a bean for password encoding.
	 *
	 * @return A BCryptPasswordEncoder bean.
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	/**
	 * Configures security filter chains for different HTTP requests and
	 * authentication methods.
	 *
	 * @param http The HttpSecurity object to configure security.
	 * @return A SecurityFilterChain bean.
	 * @throws Exception If an exception occurs during configuration.
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((requests) -> requests.requestMatchers("/", "/home", "/js/**", "/css/**")
				.permitAll()
				.requestMatchers("/bidList/**", "/curvePoint/**", "/rating/**", "/ruleName/**", "/trade/**", "/user/**")
				.authenticated().anyRequest().permitAll())
				.formLogin((form) -> form.loginPage("/login").permitAll())
				.logout((logout) -> logout.permitAll());

		return http.build();
	}
}