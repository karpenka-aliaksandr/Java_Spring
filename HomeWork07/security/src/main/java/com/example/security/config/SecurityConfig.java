package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests(authorize -> authorize
			.requestMatchers("/", "/index").permitAll()
			.requestMatchers("/public-data").hasAnyRole("USER")
			.requestMatchers("/private-data").hasAnyRole("ADMIN")
			.anyRequest().authenticated()
		)
		.formLogin(login -> login
				.defaultSuccessUrl("/index")
				.permitAll())
		.logout(logout -> logout
				.logoutSuccessUrl("/index"));
        return http.build();
    }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	UserDetailsManager inMemoryUserDetailsManager() {
		var user1 = User.withUsername("user").password("{noop}password").roles("USER").build();
		var user2 = User.withUsername("admin").password("{noop}password").roles("ADMIN", "USER").build();
		return new InMemoryUserDetailsManager(user1, user2);
	}
}
