package main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig{
	
	private final UserDetailsService userService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/signin","/signup","/actuator/**").permitAll()
			.antMatchers("/*").authenticated()
			.and()
			.formLogin()
			.loginPage("/signin")
			.usernameParameter("email")
			.passwordParameter("password")
			.defaultSuccessUrl("/")
			.loginProcessingUrl("/login")
			.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/signin")
			.invalidateHttpSession(true)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.maximumSessions(1);
			http.authenticationProvider(dao());
		return http.build();
	}
	
	@Bean
	public AuthenticationProvider dao() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userService);
		dao.setPasswordEncoder(passwordEncoder());
		return dao;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
