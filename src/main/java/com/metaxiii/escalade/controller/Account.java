package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Account {
	@RequestMapping("/account")
	public String account() {
		// Pour récupèrer les infos users. Tu peux aussi envisager de faire implémenter UserDetails à ton objet user pour pouvoir recupèrer ses informations
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
		return "account";
	}
}
