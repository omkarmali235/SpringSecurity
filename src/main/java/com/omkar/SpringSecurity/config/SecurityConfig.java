package com.omkar.SpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RequestBody;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
	return http.csrf(customizer -> customizer.disable()) //disable authorisation
			.authorizeHttpRequests(request -> request.anyRequest().authenticated()) // authorise all request 
			.formLogin(Customizer.withDefaults()) //frompostman
		    .httpBasic(Customizer.withDefaults()) //fromhtml
		 	.sessionManagement(session -> 
		 				session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //want to generate new sessionid for each request
		 	.build();
		
	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user1 =User
//				.withDefaultPasswordEncoder()
//				.username("Omi")
//				.password("O@123")
//				.roles("USER")
//				.build();
//		
//		UserDetails user2 =User
//				.withDefaultPasswordEncoder()
//				.username("Rucha")
//				.password("R@123")
//				.roles("ADMIN")
//				.build();		
//		
//		UserDetails user3 =User
//				.withDefaultPasswordEncoder()
//				.username("Rekha")
//				.password("R@123")
//				.roles("USER")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user1,user2,user3);
//		}
		
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailsService);
		return provider;
		
	}
}

