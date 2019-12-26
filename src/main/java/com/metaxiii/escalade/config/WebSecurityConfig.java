package com.metaxiii.escalade.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/", "/user/**", "/search", "/thanks", "/topo").permitAll()
			.antMatchers("/css/**", "/js/**", "/img/**", "/vendor/**").permitAll()
			.antMatchers(HttpMethod.GET, "/user/new-user", "/user/login").permitAll()
			.antMatchers(HttpMethod.POST, "/user/new-user", "/user/login").permitAll()
//			.antMatchers("/account").authenticated()
//			.anyRequest().authenticated()
			.anyRequest().permitAll()
		.and()
			.authenticationProvider(authProvider())
			.formLogin()
			.loginPage("/user/login") //
			.failureUrl("/user/login?error")// L'url de la page de login
			.defaultSuccessUrl("/welcome") // L'url de redirection après authentification
			.usernameParameter("username") // Le name de l'input du form correspond au login
			.passwordParameter("password") //// Le name de l'input du form correspond au password
		.and()
			.logout()
			.invalidateHttpSession(true)
			.logoutUrl("/user/logout")
			.logoutSuccessUrl("/user/login?logout")
		.and()
			.csrf()
			.disable()
		;
	}


	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder);
		return authProvider;
	}
}
