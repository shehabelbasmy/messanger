package main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig{
	
	private final AuthenticationProvider authenticationProvider;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/signin","/signup","/actuator/**","/","/signupHandler").permitAll()
			.antMatchers("/*").authenticated()
			.anyRequest().authenticated()
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
			http.authenticationProvider(authenticationProvider);
		return http.build();
	}
}
