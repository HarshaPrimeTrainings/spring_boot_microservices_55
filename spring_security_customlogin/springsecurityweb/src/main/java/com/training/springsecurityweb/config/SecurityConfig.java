package com.training.springsecurityweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain initSecurityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests(req-> req.requestMatchers("/home").permitAll().anyRequest().authenticated())
		.formLogin(form->form.loginPage("/login").permitAll())
		.logout(logout->logout.permitAll())
		.csrf(csrf->csrf.disable());
		return http.build();
	}
}
