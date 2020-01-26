package com.metaxiii.escalade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {
	@GetMapping("/user/login")
	public ModelAndView connectUser(Model model) {
		return new ModelAndView("login");
	}
}
