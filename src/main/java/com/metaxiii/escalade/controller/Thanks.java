package com.metaxiii.escalade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Thanks {
	@GetMapping("/thanks")
	public ModelAndView thanks() {
		return new ModelAndView("thanks");
	}
}
