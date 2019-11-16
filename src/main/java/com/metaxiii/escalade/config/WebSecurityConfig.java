package com.metaxiii.escalade.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * * Exemple de fichier de configuration pour spring secutity
 */

@Configuration
@EnableWebMvc
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;

	public WebSecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/img/**", "/css/**", "/js/**").permitAll() //
				.anyRequest().authenticated() // Tout le reste il faut etre identifier
				.and()
				.formLogin()
				.loginPage("/connect") // L'url de la page de login
				.defaultSuccessUrl("/") // L'url de redirection après authentification
				.failureUrl("/connect") // L'url de redirection après erreur authentification
				.usernameParameter("username") // Le name de l'input du form correspond au login
				.passwordParameter("password") //// Le name de l'input du form correspond au password
				.and()
				.logout()
				.invalidateHttpSession(true)
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
				.and()
				.csrf()
		;
	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

}
