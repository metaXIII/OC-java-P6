package com.metaxiii.escalade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Administration {
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
