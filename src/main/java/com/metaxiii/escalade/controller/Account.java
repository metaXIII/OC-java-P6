package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Account  {
	@RequestMapping("/account")
	public String account() {
		// Pour récupèrer les infos users.
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// Pour récupèrer les detail users (ip, session)
		WebAuthenticationDetails details = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
		// Pour récupèrer les roles users
		String role =  SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.findFirst()
				.orElse("");
		return "account";
	}
}
